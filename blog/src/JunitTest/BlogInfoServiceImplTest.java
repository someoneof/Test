package JunitTest;

import static org.junit.Assert.fail;
import myblog.bean.BlogInfo;
import myblog.servImpl.user.BlogInfoServiceImpl;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BlogInfoServiceImplTest {

	private static BlogInfoServiceImpl daoImpl;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		daoImpl = (BlogInfoServiceImpl) ctx.getBean("blogInfoServiceImpl");
	}
	
	@Test
	public void test()
	{
	}
	
	@Test
	public void testsave()
	{
		BlogInfo blog=new BlogInfo();
		blog.setBlogtitle("wodeboke");
		blog.setDigest("fengyiyangdenanzi");
		blog.setUsername("2lalala");
		daoImpl.addBlogInfo(blog);
	}

	@Test
	public void testupdateBlogInfo()
	{
		BlogInfo blog=daoImpl.findBlog("1caonima");
		blog.setUsername("2caonima");
		blog.setBlogtitle("");
		daoImpl.updateBlogInfo(blog);
//		System.out.println(blog.getBlogtitle());
	}
	
	@Test
	public void testfindBlog()
	{
		BlogInfo blog=daoImpl.findBlog("1caonima");
		System.out.println(blog.getUsername());
	}
}
