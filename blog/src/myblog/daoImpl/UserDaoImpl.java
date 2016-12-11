package myblog.daoImpl;



import myblog.bean.User;
import myblog.dao.DaoSupport;
import myblog.dao.UserDao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends DaoSupport implements UserDao
{

	@Override
	public void register(User user)
	{
		save(user);
	}

	@Override
	public User findByUsername(String username)
	{
		String hql="where u.username='"+username+"'";
		return find(User.class,hql);
	}
	


	@SuppressWarnings("unchecked")
	@Override
	public User login(String username, String password)
	{
		String hql="where u.username='"+username+"' and u.password='"+password+"'";
		return find(User.class,hql);
	}
	
	public void deleteUser(String wherehql)
	{
		delete(User.class, wherehql);
	}

	@Override
	public void updateUser(User user)
	{
		update(user);
		
	}

}
