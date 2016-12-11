package myblog.service;

import myblog.bean.Article;
import myblog.bean.QueryResult;

public interface ArticleService {
	void addArticle(Article art);

	void deleteArticleByName(String... artname);

	void deleteArticle(String username);

	<T> QueryResult<T> findAll(int first, int last);

	<T> QueryResult<T> findByPage(int first, int last, String username);

	void updateArticle(Article art);
	
	public Article showAticle(String username,long id);
}
