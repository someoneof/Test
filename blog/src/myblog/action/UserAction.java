package myblog.action;

import java.util.Map;

import myblog.bean.BlogInfo;
import myblog.bean.User;
import myblog.dao.BlogInfoDao;
import myblog.service.UserService;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.validator.annotations.Validations;

public class UserAction extends MyActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user = new User();

	@Autowired
	private UserService userServiceImpl;
	@Autowired
	private BlogInfoDao blogInfoDaoImpl;

	@Validations
	public String register()
	{
		try
		{
			userServiceImpl.register(user);
			return "reg_success";
		} catch (Exception e)
		{
			e.printStackTrace();
			return "input";
		}
	}

	@SkipValidation
	public String login()
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		BlogInfo blog=blogInfoDaoImpl.findBlog(username);
		System.out.println("username= "+username+"  password= "+password);
		try{
			request.setAttribute("url", "art_findByUsername.action");
			request.setAttribute("info", "登陆成功");
			// 将username保存到session范围中
			// HttpSession session =request.getSession();
			Map<String, Object> session = ActionContext.getContext().getSession();
			// session.setAttribute("username", username);
			session.put("username", username);
			session.put("blogtitle", blog.getBlogtitle());
			session.put("digest", blog.getDigest());
			return "login_succ";
		} catch(Exception e)
		{
			request.setAttribute("url", "login.jsp");
			request.setAttribute("info", "登陆失败");
			return "login_fail";
		}

	}

	@Override
	public void validate()
	{
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setNickname(request.getParameter("nickname"));
		user.setQuestion(request.getParameter("question"));
		user.setAnswer(request.getParameter("answer"));

		if (user.getUsername() == null || "".equals(user.getUsername().trim()))
			this.addFieldError("username", "用户名不能为空");
		else if (userServiceImpl.findByUsername(user.getUsername()) != null)
			this.addFieldError("username", "用户名已被注册");
		if (user.getPassword() == null || "".equals(user.getPassword().trim()))
			this.addFieldError("password", "密码不能为空");
		if (user.getNickname() == null || "".equals(user.getNickname().trim()))
			this.addFieldError("nickname", "昵称不能为空");
		if (user.getAnswer() == null || "".equals(user.getAnswer().trim()))
			this.addFieldError("answer", "答案不能为空");
		if (request.getParameter("repassword") == null
				|| "".equals(request.getParameter("repassword").trim()))
			this.addFieldError("repassword", "确认密码不能为空");
	}

}
