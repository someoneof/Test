package myblog.service;


import myblog.bean.User;

public interface UserService
{
	public void register(User user);
	
	public User findByUsername(String username);

	public User login(String username,String password);
	
	public void updateUser(User user);
}
