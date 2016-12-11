package myblog.action;

import myblog.bean.BlogInfo;
import myblog.service.BlogInfoService;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.validator.annotations.Validations;

public class BlogInfoAction extends MyActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private BlogInfoService blogInfoServiceImpl;

	@Validations
	public String setBlogInfo()
	{
		String username = (String) request.getSession()
				.getAttribute("username");
		BlogInfo blog = blogInfoServiceImpl.findBlog(username);
		blog.setBlogtitle(request.getParameter("blogtitle"));
		blog.setDigest(request.getParameter("digest"));
		System.out.println(blog.toString());
		try
		{
			blogInfoServiceImpl.updateBlogInfo(blog);
			return "set_success";
		} catch (Exception e)
		{
			return "input";
		}
	}

	@Override
	public void validate()
	{
		if (request.getParameter("blogtitle") == null && "".equals(request.getParameter("blogtitle").trim()))
			this.addFieldError("blogtitle", "博客标题不能为空");
		if (request.getParameter("digest") == null && "".equals(request.getParameter("digest").trim()))
			this.addFieldError("digest", "个性签名不能为空");
	}

}
