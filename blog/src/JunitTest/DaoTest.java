package JunitTest;

import myblog.bean.QueryResult;
import myblog.bean.User;
import myblog.dao.DaoSupport;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {
	private static DaoSupport dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		dao = (DaoSupport) ctx.getBean("daoSupport");
	}

	@Test
	public void testsave()
	{
		for (int i = 0; i < 20; i++)
		{
			User user = new User();
			user = new User();
			user.setUsername(i + "caonima");
			user.setPassword("cao");
			user.setNickname("caoniam");
			user.setAnswer("sss");
			user.setQuestion("sss");
			dao.save(user);
		}
	}

	@Test
	public void testgetScrollData()
	{
		//字符串类型的hql语句要将字符串包含在''内
		/*QueryResult<User> qr=dao.getScrollData(User.class, 0, 3, "where u.password='"+"caoa'");
		for(User u:qr.getResultlist())
			System.out.println(u.getUsername());*/
//		QueryResult<User> qr=dao.getScrollData(User.class, 0, 10, null);
		QueryResult<User> qr=dao.getScrollData(User.class);
		for(User u:qr.getResultlist())
			System.out.println(u.getUsername());
	}
}
