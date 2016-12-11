package myblog.dao;

import myblog.bean.Article;
import myblog.bean.QueryResult;

public interface ArticleDao {
	
	/**
	 * 添加文章
	 * @param art Articl实体
	 */
	void addArticle(Article art);
	
	/**
	 * 删除文章
	 * @param artname 文章名数组
	 */
	void deleteArticleByName(String...artname);
	
	/**
	 * 删除文章
	 * @param username 文章名
	 */
	void deleteArticle(String username);

	/**
	 * 查找所有文章
	 * @return 结果集
	 */
	<T> QueryResult<T> findAll(int first,int last);
	
	/**
	 * 分页查询
	 * @param first 开始索引位置
	 * @param last 每一页的记录
	 * @param username 用户名
	 * @return
	 */
	<T> QueryResult<T> findByPage(int first,int last,String username);
	
	/**
	 * 更新文章信息
	 * @param art 文章实体
	 */
	void updateArticle(Article art);
	
	/**
	 * 显示文章内容
	 * @param username 用户名
	 * @param title 文章标题
	 */
	public Article showAticle(String username,long id);
	

}
