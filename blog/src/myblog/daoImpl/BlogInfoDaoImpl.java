package myblog.daoImpl;

import org.springframework.stereotype.Repository;

import myblog.bean.BlogInfo;
import myblog.dao.BlogInfoDao;
import myblog.dao.DaoSupport;

@Repository
public class BlogInfoDaoImpl extends DaoSupport implements BlogInfoDao {

	@Override
	public void addBlogInfo(BlogInfo blog)
	{
			save(blog);
	}

	@Override
	public void updateBlogInfo(BlogInfo blog)
	{
		update(blog);
	}

	@Override
	public BlogInfo findBlog(String username)
	{
		String wherehql = "where u.username='" + username + "'";
		return find(BlogInfo.class, wherehql);
	}

}
