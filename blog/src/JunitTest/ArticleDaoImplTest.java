package JunitTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import myblog.bean.Article;
import myblog.bean.QueryResult;
import myblog.daoImpl.ArticleDaoImpl;
import myblog.servImpl.user.ArticleServiceImpl;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArticleDaoImplTest {

	private static ArticleDaoImpl dao;
	private static ArticleServiceImpl daoImpl;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		dao = (ArticleDaoImpl) ctx.getBean("articleDaoImpl");
		daoImpl = (ArticleServiceImpl) ctx.getBean("articleServiceImpl");
	}

	@Test
	public void testsave() throws ParseException
	{
		for (int i = 0; i < 100; i++)
		{
			Article art = new Article();
			art.setTitle(i + "wenzhang");
			art.setContent("meiyou");
			art.setHasread(1);
			art.setUsername("2lalala");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String df1 = df.format(new Date());
			art.setDatetime(df.parse(df.format(new Date())));
			dao.save(art);
		}
	}

	@Test
	public void testfindAll()
	{
		System.out.println(daoImpl == null);
		QueryResult<Article> qr = daoImpl.findAll(1, 5);
		for (Article t : qr.getResultlist())
			System.out.println(t.getTitle());
	}

	@Test
	public void testfindByPage()
	{
		QueryResult<Article> qr = daoImpl.findByPage(1, 6, "1caonima");
		for (Article t : qr.getResultlist())
			System.out.println("totalRecord= " + qr.getTotalRecord() + "  "
					+ t.getTitle());
	}

	@Test
	public void testdeleteArticle()
	{
		dao.deleteArticle("where u.aname='0wenzhang'");
	}

	@Test
	public void testdeleteArticleByName()
	{
		dao.deleteArticleByName("1wenzhang", "2wenzhang", "3wenzhang");
	}

	@Test
	public void testDate() throws ParseException
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		System.out.println(df.parse(df.format(new Date())));
	}

	@Test
	public void test()
	{
	}

	@Test
	public void testshowArticle()
	{
		Article art = dao.showAticle("1caonima", 39);
		int end=art.getContent().toString().indexOf("</p>");
		System.out.println("   end= "+end);
		System.out.println(art.getContent());
		System.out.println(art.getTitle());
		String s=art.getContent().toString().substring(3,end);
		System.out.println(s);
	}

	@Test
	public void testupdate()
	{
		Article art = dao.showAticle("1caonima", 1);
		long count = art.getHasread() + 1;
		System.out.println("count= " + art.getHasread());
		art.setHasread(count);
		dao.update(art);
		art = dao.showAticle("1caonima", 1);
		System.out.println("count= " + art.getHasread());

	}
}
