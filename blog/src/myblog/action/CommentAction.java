package myblog.action;

import myblog.bean.Article;
import myblog.bean.Comment;
import myblog.bean.PageIndex;
import myblog.bean.QueryResult;
import myblog.bean.WebTool;
import myblog.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;


public class CommentAction extends MyActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CommentService commentServiceImpl;
	
	public String showComment()
	{
		String username = request.getParameter("username");
		String title=request.getParameter("title");
		System.out
				.println("========================================Ö´ÐÐfindByUsername================"
						+ username);
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

}
