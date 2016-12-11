package JunitTest;

import myblog.bean.Comment;
import myblog.bean.QueryResult;
import myblog.servImpl.user.CommentServiceImpl;
import myblog.service.CommentService;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommentServiceImplTest {

	private static CommentService daoImpl;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		daoImpl = (CommentServiceImpl) ctx.getBean("commentServiceImpl");
	}

	@Test
	public void test()
	{
	}

	@Test
	public void testsave()
	{
		Comment comment = new Comment();
		for (int i = 0; i < 100; i++)
		{
			comment.setContent(i + "hahahahahhahah");
			comment.setTitle("0wenzhang");
			comment.setUsername("1caonima");
			daoImpl.add(comment);
		}
	}
	@Test
	public void testfindByPage()
	{
		QueryResult<Comment> qr=daoImpl.findByPage(1,10,"0wenzhang", "0caonima");
		for(Comment c:qr.getResultlist())
			System.out.println(c.getContent());
	}
	@Test
	public void testdelete()
	{
		daoImpl.delete("0wenzhang", "0caonima", "1hahahahahhahah");
	}
}
