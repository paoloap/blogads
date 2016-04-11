package it.ads.blogads.model.entity;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Entity bean Comment for table Comment
 * @author Paolo Porcedda
 *
 */
@Entity
@Table(name="article")
public class Comment implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Column COMMENT_ID
	 */
	@Id
	@Column(name="COMMENT_ID",unique=true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional = false)
	private Integer id;
	
	/**
	 * Column C_AUTHOR
	 */
	@Column(name="C_AUTHOR", nullable = false)
	private String author;
	
	/**
	 * Column C_EMAIL
	 */
	@Column(name="C_EMAIL", nullable = false)
	private String email;
	
	/**
	 * Column C_BODY
	 */
	@Column(name="C_BODY", nullable = false)
	private String body;
	
	/**
	 * Mapped by table Article
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "C_ARTICLE_ID", referencedColumnName = "ARTICLE_ID", nullable = false)
	private Article article;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
	
	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}
	
	/**
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}
	
	/**
	 * @param article the article to set
	 */
	public void setArticle(Article article) {
		this.article = article;
	}
}

