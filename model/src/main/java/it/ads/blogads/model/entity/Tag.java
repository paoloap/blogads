package it.ads.blogads.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 * Entity bean Tag for table Tag
 * @author Paolo Porcedda
 *
 */
@Entity
@Table(name="tag")
public class Tag implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Column TAG_ID
	 */
	@Id
	@Column(name="TAG_ID",unique=true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional = false)
	private Integer id;
	
	/**
	 * Column T_NAME
	 */
	@Column(name="T_NAME", nullable = false)
	private String name;
	
	/**
	 * Mapped by join table Article_Tag 
	 */
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
    @JoinTable(name="Article_Tag", 
                joinColumns={@JoinColumn(name="TAG_ID", nullable = false)}, 
                inverseJoinColumns={@JoinColumn(name="ARTICLE_ID", nullable = false)})
	private Set<Article> articles;
	
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the articles
	 */
	public Set<Article> getArticles() {
		if(articles == null){
			setArticles(new HashSet<Article>(0));
		}
		return articles;
	}
	
	/**
	 * @param articles the articles to set
	 */
	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
}
