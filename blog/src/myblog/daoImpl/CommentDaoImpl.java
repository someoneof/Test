package myblog.daoImpl;

import myblog.bean.Comment;
import myblog.bean.QueryResult;
import myblog.dao.CommentDao;
import myblog.dao.DaoSupport;

import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoImpl extends DaoSupport implements CommentDao {

	@Override
	public void add(Comment comment)
	{
		save(comment);
	}

	@Override
	public void delete(String title, String username,String content)
	{
		String hql="where u.title='"+title+"' and u.username='"+username+"' and u.content='"+content+"'";
		delete(Comment.class, hql);

	}

	@Override
	public void update(Comment comment)
	{
		update(comment);

	}

	@Override
	public QueryResult<Comment> findByPage(int first, int last,String title, String username)
	{
		String wherehql="where u.title='"+title+"' and username='"+username+"'";
		return getScrollData(Comment.class, first, last, wherehql);
	}

}
