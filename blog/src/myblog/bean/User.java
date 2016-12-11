package myblog.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/* 1.一对多,多对一分清,  一   OneToMany  多  ;多    ManyToOne   一
 * 级联操作,如果对这个实体bean调用Refresh方法,就会对底下的子类别刷新操作
 *如果对父类调用删除操作,它也会对底下的子类别进行删除操作
 *双向关系要定义维护方和被维护方
 *在一对多中,就在一的一方定义成被维护端,维护端就是多的一方,哪个属性进行映射关系的维护(parent)
 * */

@Entity
// name的意思是这个实体类的名字
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@TableGenerator(initialValue = 1, allocationSize = 1, name = "userid")
	@Column(name = "userid")
	private long id;

	@Column(name = "username", nullable = true)
	private String username;

	@OneToMany(cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
	@JoinColumn(name = "username")   //在另外一张表中的列名
	private Set<Article> articles = new HashSet<Article>();
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name="username")
	private Set<Comment> comments=new HashSet<Comment>();

	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE}) 
	@JoinColumn(name="username",insertable=false,updatable=false)
	@NotFound(action=NotFoundAction.IGNORE)  // Hibernate异常No row with the given identifier exists 解决方法
	private BlogInfo bloginfo;
	
	@Column(name = "password", nullable = true)
	private String password;

	@Column(name = "nickname", nullable = true)
	private String nickname;

	@Column(name = "question", nullable = true)
	private String question;

	@Column(name = "answer", nullable = true)
	private String answer;

	@Override
	public String toString()
	{
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", nickname=" + nickname + ", question="
				+ question + ", answer=" + answer + "]";
	}

	public User()
	{
	}
	
	

	public Set<Comment> getComments()
	{
		return comments;
	}

	public void setComments(Set<Comment> comments)
	{
		this.comments = comments;
	}

	public String getTableName()
	{
		return "username";
	}

	public User(long id, String username, String password, String nickname,
			String question, String answer)
	{
		this.id = id;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.question = question;
		this.answer = answer;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public Set<Article> getArticles()
	{
		return articles;
	}

	public void setArticles(Set<Article> articles)
	{
		this.articles = articles;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public String getQuestion()
	{
		return question;
	}

	public void setQuestion(String question)
	{
		this.question = question;
	}

	public String getAnswer()
	{
		return answer;
	}

	public void setAnswer(String answer)
	{
		this.answer = answer;
	}

}
/*
 * create table user{ 'userid',varchar(11),not null
 */
