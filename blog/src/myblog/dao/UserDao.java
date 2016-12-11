package myblog.dao;


import myblog.bean.User;


public interface UserDao {
	/**
	 * 注册
	 * @param user User对象
	 */
	public void register(User user);

	/**
	 * 根据userame查找
	 * @param username User对象的username
	 * @return
	 */
	public User findByUsername(String username);

	/**
	 * 登陆
	 * @param username username
	 * @param password password
	 * @return
	 */
	public User login(String username, String password);
	
	/**
	 * 删除用户
	 * @param wherehql 条件语句
	 */
	public void deleteUser(String wherehql);
	
	public void updateUser(User user);

}
