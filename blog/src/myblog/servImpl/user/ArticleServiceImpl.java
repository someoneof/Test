package myblog.servImpl.user;

import myblog.bean.Article;
import myblog.bean.QueryResult;
import myblog.dao.ArticleDao;
import myblog.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDaoImpl;

	@Override
	public void addArticle(Article art)
	{
		articleDaoImpl.addArticle(art);
	}

	@Override
	public void deleteArticleByName(String... artname)
	{
		articleDaoImpl.deleteArticleByName(artname);
	}

	@Override
	public void deleteArticle(String username)
	{
		articleDaoImpl.deleteArticle(username);
	}

	@Override
	public <T> QueryResult<T> findAll(int first, int last)
	{
		return articleDaoImpl.findAll(first, last);
	}

	@Override
	public <T> QueryResult<T> findByPage(int first, int last, String username)
	{
		return articleDaoImpl.findByPage(first, last, username);
	}

	@Override
	public void updateArticle(Article art)
	{
		articleDaoImpl.updateArticle(art);
	}
	
	public Article showAticle(String username, long id)
	{
		return articleDaoImpl.showAticle(username, id);
	}


}
