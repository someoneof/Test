package myblog.daoImpl;

import org.springframework.stereotype.Repository;

import myblog.bean.Article;
import myblog.bean.QueryResult;
import myblog.dao.ArticleDao;
import myblog.dao.DaoSupport;

@Repository
public class ArticleDaoImpl extends DaoSupport implements ArticleDao {

	@Override
	public void addArticle(Article art)
	{
		save(art);
	}

	@Override
	public void deleteArticleByName(String... artname)
	{
		for (int i = 0; i < artname.length; i++)
			deleteArticle(artname[i]);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> QueryResult<T> findAll(int first, int last)
	{
		return (QueryResult<T>) findByPage(first, last, null);
	}

	@Override
	public void updateArticle(Article art)
	{
		update(art);
	}

	@Override
	public void deleteArticle(String artname)
	{
		String wherehql = "where u.aname='" + artname + "'";
		delete(Article.class, wherehql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> QueryResult<T> findByPage(int first, int last, String username)
	{
		String hql = null;
		if (username != null)
			hql = "where u.username='" + username + "'";
		return (QueryResult<T>) getScrollData(Article.class, first, last, hql);
	}

	@Override
	public Article showAticle(String username, long id)
	{
		String wherehql="where u.username='"+username+"' and u.aid='"+id+"'";
		return find(Article.class, wherehql);
	}

}
