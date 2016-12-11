package myblog.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import myblog.bean.Article;
import myblog.bean.Comment;
import myblog.bean.PageIndex;
import myblog.bean.QueryResult;
import myblog.bean.WebTool;
import myblog.servImpl.user.ArticleServiceImpl;
import myblog.service.CommentService;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.validator.annotations.Validations;

public class ArticleAction extends MyActionSupport {

	@Autowired
	private ArticleServiceImpl articleServiceImpl;
	
	@Autowired
	private CommentService commentServiceImpl;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SkipValidation
	public String findByUsername()
	{
		String username = request.getParameter("username");
		System.out
				.println("========================================执行findByUsername================"
						+ username);
		int pagecount = 12;
		String cur = request.getParameter("currpage");
		int curpage = 1;
		if (cur != null)
			curpage = Integer.parseInt(cur);
		System.out.println("currpage= " + curpage);
		int firstindex = (curpage - 1) * pagecount;
		QueryResult<Article> qr = articleServiceImpl.findByPage(firstindex,
				pagecount, username);
		for (Article art : qr.getResultlist())
			System.out.println(art.getTitle());
		long totalpage = qr.getTotalRecord() % pagecount == 0 ? qr
				.getTotalRecord() / pagecount : qr.getTotalRecord() / pagecount
				+ 1;
		PageIndex pageindex = WebTool.getPageIndex(pagecount, curpage,
				totalpage);
		request.setAttribute("curpage", curpage);
		request.setAttribute("pageindex", pageindex);
		request.setAttribute("article_list", qr.getResultlist());
		return "find_art_succ";
	}

	@SkipValidation
	public String findAll()
	{
		int pagecount = 12;
		String cur = request.getParameter("currpage");
		int curpage = 1;
		if (cur != null)
			curpage = Integer.parseInt(cur);
		System.out.println("currpage= " + curpage);
		int firstindex = (curpage - 1) * pagecount;
		QueryResult<Article> qr = articleServiceImpl.findByPage(firstindex,
				pagecount, null);
		long totalpage = qr.getTotalRecord() % pagecount == 0 ? qr
				.getTotalRecord() / pagecount : qr.getTotalRecord() / pagecount
				+ 1;
		PageIndex pageindex = WebTool.getPageIndex(pagecount, curpage,
				totalpage);
		request.setAttribute("curpage", curpage);
		request.setAttribute("pageindex", pageindex);
		request.setAttribute("article_list", qr.getResultlist());
		return "findAll_art";
	}

	@SkipValidation
	public String showArticle()
	{
		String username = request.getParameter("username");
		long id = Integer.parseInt(request.getParameter("aid"));
		System.out.println("===================执行showArticle,username= "
				+ username + "id= " + id);
		Article article = articleServiceImpl.showAticle(username, id);
		long count = article.getHasread() + 1;
		article.setHasread(count);
		articleServiceImpl.updateArticle(article);
		request.setAttribute("content", article.getContent());
		request.setAttribute("title", article.getTitle());
		
		String title=request.getParameter("title");
		int pagecount = 12;
		String cur = request.getParameter("currpage");
		int curpage = 1;
		if (cur != null)
			curpage = Integer.parseInt(cur);
		System.out.println("currpage= " + curpage);
		int firstindex = (curpage - 1) * pagecount;
		QueryResult<Comment> qr = commentServiceImpl.findByPage(firstindex,
				pagecount,title,username);
		for (Comment comment : qr.getResultlist())
			System.out.println(comment.getTitle());
		long totalpage = qr.getTotalRecord() % pagecount == 0 ? qr
				.getTotalRecord() / pagecount : qr.getTotalRecord() / pagecount
				+ 1;
		PageIndex pageindex = WebTool.getPageIndex(pagecount, curpage,
				totalpage);
		request.setAttribute("curpage", curpage);
		request.setAttribute("pageindex", pageindex);
		request.setAttribute("comment_list", qr.getResultlist());
		return "show_success";
	}

	@Validations
	public String addArticle() throws ParseException
	{
		System.out.println("=====================开始执行addArticle");
		Article art = new Article();
		String content=request.getParameter("content");
		int end=content.indexOf("</p>");
		content=content.substring(3,end);
		System.out.println("==============================================content= "+content);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		art.setDatetime(df.parse(df.format(new Date())));
		art.setUsername((String) request.getSession().getAttribute("username"));
		art.setTitle(request.getParameter("title"));
		art.setContent(content);
		try
		{
			articleServiceImpl.addArticle(art);
			return "add_success";
		} catch (Exception e)
		{
			return "input";
		}
	}

	@Override
	public void validate()
	{
		System.out.println("=====================开始执行表单验证");
		String title = request.getParameter("title");
		if (title == null && "".equals(title.trim()))
			this.addFieldError("title", "标题不能为空");
	}

}
