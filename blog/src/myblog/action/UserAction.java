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
			request.setAttribute("info", "��½�ɹ�");
			// ��username���浽session��Χ��
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
			request.setAttribute("info", "��½ʧ��");
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
			this.addFieldError("username", "�û�������Ϊ��");
		else if (userServiceImpl.findByUsername(user.getUsername()) != null)
			this.addFieldError("username", "�û����ѱ�ע��");
		if (user.getPassword() == null || "".equals(user.getPassword().trim()))
			this.addFieldError("password", "���벻��Ϊ��");
		if (user.getNickname() == null || "".equals(user.getNickname().trim()))
			this.addFieldError("nickname", "�ǳƲ���Ϊ��");
		if (user.getAnswer() == null || "".equals(user.getAnswer().trim()))
			this.addFieldError("answer", "�𰸲���Ϊ��");
		if (request.getParameter("repassword") == null
				|| "".equals(request.getParameter("repassword").trim()))
			this.addFieldError("repassword", "ȷ�����벻��Ϊ��");
	}

}
