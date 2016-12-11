package myblog.service;

import myblog.bean.BlogInfo;

public interface BlogInfoService {
	
	
	void addBlogInfo(BlogInfo blog);

	void updateBlogInfo(BlogInfo blog);
	
	public BlogInfo findBlog(String username);
}
