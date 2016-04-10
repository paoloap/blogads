package it.ads.blogads.model.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 * Entity bean Article for table Article
 * @author Paolo Porcedda
 *
 */
@Entity
@Table(name="article")
public class Article implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Column ARTICLE_ID
	 */
	@Id
	@Column(name="ARTICLE_ID",unique=true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional = false)
	private Integer id;
	
	/**
	 * Column A_AUTHOR
	 */
	@Column(name="A_AUTHOR", nullable = false)
	private String author;
	
	/**
	 * Column A_TITLE
	 */
	@Column(name="A_TITLE", nullable = false)
	private String title;
	
	/**
	 * Column A_BODY
	 */
	@Column(name="A_BODY", nullable = false)
	private String body;
	
	/**
	 * Column A_DATA
	 */
	@Column(name="A_DATA", nullable = false)
	private Date data;
	
	/**
	 * Mapped by table Comment
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "article", cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	private Set<Comment> comments;
	
	/**
	 * Mapped by join table Article_Tag 
	 */
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
    @JoinTable(name="Article_Tag", 
                joinColumns={@JoinColumn(name="ARTICLE_ID", nullable = false)}, 
                inverseJoinColumns={@JoinColumn(name="TAG_ID", nullable = false)})
	private Set<Tag> tags;
	
	
	public Article() {
	}
	
	/**
	 * @return the tags
	 */
	public Set<Tag> getTags() {
		if(tags == null){
			setTags(new HashSet<Tag>(0));
		}
		return tags;
	}
	
	/**
	 * @param tags the tags to set
	 */
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the comments
	 */
	public Set<Comment> getComments() {
		if(comments == null){
			setComments(new HashSet<Comment>(0));
		}
		return comments;
	}
	
	/**
	 * @param comments the comments to set
	 */
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}
	
	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}
	
}