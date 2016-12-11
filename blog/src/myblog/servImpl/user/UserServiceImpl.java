package myblog.servImpl.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myblog.bean.User;
import myblog.dao.UserDao;
import myblog.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userDaoImpl;

	@Override
	public void register(User user)
	{
		this.userDaoImpl.register(user);
	}


	@Override
	public User login(String username, String password)
	{
		return this.userDaoImpl.login(username, password);
	}


	@Override
	public User findByUsername(String username)
	{
		return this.userDaoImpl.findByUsername(username);
	}


	@Override
	public void updateUser(User user)
	{
		this.userDaoImpl.updateUser(user);
	}

}
