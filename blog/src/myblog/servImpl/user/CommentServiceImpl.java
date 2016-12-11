package myblog.servImpl.user;

import myblog.bean.Comment;
import myblog.bean.QueryResult;
import myblog.dao.CommentDao;
import myblog.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDaoImpl;

	@Override
	public void add(Comment comment)
	{
		commentDaoImpl.add(comment);
	}

	@Override
	public void delete(String title, String username,String content)
	{
		commentDaoImpl.delete(title, username,content);

	}

	@Override
	public void update(Comment comment)
	{
		commentDaoImpl.update(comment);
	}

	@Override
	public QueryResult<Comment> findByPage(int first,int count,String title, String username)
	{
		return commentDaoImpl.findByPage(first,count,title, username);
	}

}
