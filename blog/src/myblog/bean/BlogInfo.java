package myblog.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bloginfo")
public class BlogInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="blogid")
	private long blogid;
	
	@Column(name="username",nullable=true)
	private String username;
	
	@Column(name="blogtitle",nullable=true)
	private String blogtitle;
	
	@Column(name="digest",nullable=true)
	private String digest;

	public long getBlogid()
	{
		return blogid;
	}

	public void setBlogid(long blogid)
	{
		this.blogid = blogid;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getBlogtitle()
	{
		return blogtitle;
	}

	public void setBlogtitle(String blogtitle)
	{
		this.blogtitle = blogtitle;
	}

	public String getDigest()
	{
		return digest;
	}

	public void setDigest(String digest)
	{
		this.digest = digest;
	}

	@Override
	public String toString()
	{
		return "BlogInfo [blogid=" + blogid + ", username=" + username
				+ ", blogtitle=" + blogtitle + ", digest=" + digest + "]";
	}
	
	
	
}
