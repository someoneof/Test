package JunitTest;

import myblog.bean.User;
import myblog.daoImpl.UserDaoImpl;
import myblog.servImpl.user.UserServiceImpl;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

	private static UserDaoImpl dao;
	private static UserServiceImpl daoImpl;

	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		dao = (UserDaoImpl) ctx.getBean("userDaoImpl");
		daoImpl=(UserServiceImpl)ctx.getBean("userServiceImpl");
	}
	
	@Test
	public void test1()
	{
	}
	
	@Test
	public void testImpl()
	{
		daoImpl.findByUsername("1caonima");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCreateTable()
	{
		Configuration cfg = new AnnotationConfiguration().configure();
		SchemaExport export = new SchemaExport(cfg);
		export.create(true, true);
	}

	@Test
	public void testsave()
	{
		for (int i = 0; i < 100; i++)
		{
			User user = new User();
			user = new User();
			user.setUsername(i + "lalala");
			user.setPassword("lalala");
			user.setNickname("lalala");
			user.setAnswer("sss");
			user.setQuestion("sss");
			dao.save(user);
		}
	}

	@Test
	public void testfindByUserName()
	{
		User qr = dao.findByUsername("0caonima");
			System.out.println(qr.getUsername());
	}


	@Test
	public void testlogin()
	{
		User user = daoImpl.login("3caonima", "cao");
		System.out.println(user.toString());
	}

	@Test
	public void testfind()
	{
		User user = dao.find(User.class, "where u.id=20");
		System.out.println(user.getUsername());
	}

	@Test
	public void testdelete()
	{
		dao.deleteUser("where u.id=20");
	}
	@Test
	public void test()
	{
	}
	
	@Test
	public void testupdate()
	{
		User user=daoImpl.findByUsername("29caonima");
		System.out.println(user.getUsername());
		user.setUsername("hahahah");
		daoImpl.updateUser(user);
		System.out.println(user.getUsername());
	}
}
