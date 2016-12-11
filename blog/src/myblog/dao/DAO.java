package myblog.dao;



import myblog.bean.QueryResult;

public interface DAO {
	
	/**
	 * ����ʵ��
	 * @param o ʵ�����
	 */
	void save(Object o);
	
	/**
	 * ɾ������
	 * @param o ʵ�����
	 */
	void delete(Object o);
	/**
	 * ����ʵ��
	 * @param o ʵ�����
	 */
	void update(Object o);
	
	/**
	 * ������������ʵ��
	 * @param entityClass ʵ�����
	 * @param id ʵ��id
	 * @return ����һ��ʵ�����
	 */
	<T> T find(Class<T>entityClass,String wherehql);
	/**
	 * �����������з�ҳ��ѯ
	 * @param entityClass ʵ��������
	 * @param first ��ʼ����λ��
	 * @param max ����ѯ��¼����
	 * @param wherehql ��ѯ����
	 * @return ÿҳ�Ľ����
	 */
	<T> QueryResult<T> getScrollData(Class<T> entityClass,int first,int max,String wherehql);
	
	/**
	 * ��ҳ��ѯ
	 * @param entityClass ������
	 * @param first 
	 * @param max
	 * @return
	 */
	<T> QueryResult<T> getScrollData(Class<T> entityClass,int first,int max);
	
	/**
	 * ��ѯ�������ж���
	 * @param entityClass ������
	 * @return �������еĶ���
	 */
	<T> QueryResult<T> getScrollData(Class<T> entityClass);
	
	/**
	 * ����������ѯ����
	 * @param entity ������
	 * @param name ��������
	 * @return
	 */
	<T> QueryResult<T> findByName(Class<T> entity,String wherehql);
	
	/**
	 * ��������ɾ��ʵ��
	 * @param entity ������
	 * @param wherehql �������
	 */
	public <T> void delete(Class<T> entity,String wherehql);

}
/*�����ڽӿڻ�������,�ڼ̳л�ʵ�ֵ�ʱ�����������*/