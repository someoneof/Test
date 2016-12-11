package myblog.dao;

import myblog.bean.Article;
import myblog.bean.QueryResult;

public interface ArticleDao {
	
	/**
	 * �������
	 * @param art Articlʵ��
	 */
	void addArticle(Article art);
	
	/**
	 * ɾ������
	 * @param artname ����������
	 */
	void deleteArticleByName(String...artname);
	
	/**
	 * ɾ������
	 * @param username ������
	 */
	void deleteArticle(String username);

	/**
	 * ������������
	 * @return �����
	 */
	<T> QueryResult<T> findAll(int first,int last);
	
	/**
	 * ��ҳ��ѯ
	 * @param first ��ʼ����λ��
	 * @param last ÿһҳ�ļ�¼
	 * @param username �û���
	 * @return
	 */
	<T> QueryResult<T> findByPage(int first,int last,String username);
	
	/**
	 * ����������Ϣ
	 * @param art ����ʵ��
	 */
	void updateArticle(Article art);
	
	/**
	 * ��ʾ��������
	 * @param username �û���
	 * @param title ���±���
	 */
	public Article showAticle(String username,long id);
	

}
