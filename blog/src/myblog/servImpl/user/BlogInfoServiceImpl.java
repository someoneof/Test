package myblog.servImpl.user;

import myblog.bean.BlogInfo;
import myblog.dao.BlogInfoDao;
import myblog.service.BlogInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogInfoServiceImpl implements BlogInfoService {

	@Autowired
	private BlogInfoDao blogInfoDaoImpl;

	@Override
	public void addBlogInfo(BlogInfo blog)
	{
		blogInfoDaoImpl.addBlogInfo(blog);

	}

	@Override
	public void updateBlogInfo(BlogInfo blog)
	{
		blogInfoDaoImpl.updateBlogInfo(blog);
	}

	@Override
	public BlogInfo findBlog(String username)
	{
		return blogInfoDaoImpl.findBlog(username);
	}
	
	

}
