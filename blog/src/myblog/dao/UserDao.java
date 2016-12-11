package myblog.dao;


import myblog.bean.User;


public interface UserDao {
	/**
	 * ע��
	 * @param user User����
	 */
	public void register(User user);

	/**
	 * ����userame����
	 * @param username User�����username
	 * @return
	 */
	public User findByUsername(String username);

	/**
	 * ��½
	 * @param username username
	 * @param password password
	 * @return
	 */
	public User login(String username, String password);
	
	/**
	 * ɾ���û�
	 * @param wherehql �������
	 */
	public void deleteUser(String wherehql);
	
	public void updateUser(User user);

}
