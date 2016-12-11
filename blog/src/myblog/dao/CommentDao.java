package myblog.dao;

import myblog.bean.Comment;
import myblog.bean.QueryResult;

public interface CommentDao {
	
	void add(Comment comment);
	
	void delete(String title,String username,String content);
	
	void update(Comment comment);
	
	QueryResult<Comment> findByPage(int first, int last,String title, String username);

}
