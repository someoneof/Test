package myblog.dao;

import myblog.bean.BlogInfo;

public interface BlogInfoDao {

	void addBlogInfo(BlogInfo blog);
	
	void updateBlogInfo(BlogInfo blog);
	
	BlogInfo findBlog(String username);
}
