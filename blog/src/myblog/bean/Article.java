package myblog.bean;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "article")
public class Article
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@TableGenerator(initialValue = 1, allocationSize = 1, name = "aid")
	private long aid;

	@Column(name = "title",nullable=false)
	private String title;

	@Column(name = "content")
	private String content;
//多篇文章对应一个人
	/*@ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.REMOVE},targetEntity=User.class)
	@JoinColumn(name = "userid",updatable=false,nullable=false)*///这里设置JoinColum设置了外键的名字，并且article是关系维护端  
	@Column(name="username",nullable=false)
	private String username;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name="title")
	private Set<Comment> comments=new HashSet<Comment>();
	
	private long hasread;
	
	private Date datetime;
	

	public long getAid()
	{
		return aid;
	}

	public void setAid(long aid)
	{
		this.aid = aid;
	}


	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Set<Comment> getComments()
	{
		return comments;
	}

	public void setComments(Set<Comment> comments)
	{
		this.comments = comments;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public long getHasread()
	{
		return hasread;
	}

	public void setHasread(long hasread)
	{
		this.hasread = hasread;
	}

	public Date getDatetime()
	{
		return datetime;
	}

	public void setDatetime(Date datetime)
	{
		this.datetime = datetime;
	}

	@Override
	public String toString()
	{
		return "Article [aid=" + aid + ", title=" + title + ", content="
				+ content + ", username=" + username + ", comments=" + comments
				+ ", hasread=" + hasread + ", datetime=" + datetime + "]";
	}
	
	
	

}
