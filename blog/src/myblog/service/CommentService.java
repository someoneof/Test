package myblog.service;

import myblog.bean.Comment;
import myblog.bean.QueryResult;

public interface CommentService {
	
	
	void add(Comment comment);

	void delete(String title, String username,String content);

	void update(Comment comment);

	QueryResult<Comment> findByPage(int first,int count,String title, String username);

}
