package myblog.dao;



import myblog.bean.QueryResult;

public interface DAO {
	
	/**
	 * 保存实体
	 * @param o 实体对象
	 */
	void save(Object o);
	
	/**
	 * 删除对象
	 * @param o 实体对象
	 */
	void delete(Object o);
	/**
	 * 更新实体
	 * @param o 实体对象
	 */
	void update(Object o);
	
	/**
	 * 根据条件查找实体
	 * @param entityClass 实体对象
	 * @param id 实体id
	 * @return 反回一个实体对象
	 */
	<T> T find(Class<T>entityClass,String wherehql);
	/**
	 * 根据条件进行分页查询
	 * @param entityClass 实体类类型
	 * @param first 开始索引位置
	 * @param max 所查询记录条数
	 * @param wherehql 查询条件
	 * @return 每页的结果集
	 */
	<T> QueryResult<T> getScrollData(Class<T> entityClass,int first,int max,String wherehql);
	
	/**
	 * 分页查询
	 * @param entityClass 类类型
	 * @param first 
	 * @param max
	 * @return
	 */
	<T> QueryResult<T> getScrollData(Class<T> entityClass,int first,int max);
	
	/**
	 * 查询表中所有对象
	 * @param entityClass 类类型
	 * @return 表中所有的对象
	 */
	<T> QueryResult<T> getScrollData(Class<T> entityClass);
	
	/**
	 * 根据条件查询对象
	 * @param entity 类类型
	 * @param name 给定条件
	 * @return
	 */
	<T> QueryResult<T> findByName(Class<T> entity,String wherehql);
	
	/**
	 * 根据条件删除实体
	 * @param entity 类类型
	 * @param wherehql 条件语句
	 */
	public <T> void delete(Class<T> entity,String wherehql);

}
/*泛型在接口或者类上,在继承或实现的时候会在子类中*/