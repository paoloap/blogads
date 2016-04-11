package it.ads.blogads.model.dao;

import java.util.List;

import it.ads.blogads.model.entity.Article;

/**
 * Interface DAO Service for entity Article
 * @author Paolo Porcedda
 */
public interface IArticleDao {
	
	/**
	* Method to save Article
	* @param article Article
	*/
	void save(Article article);
	
	/**
	* Method to update Article
	* @param article Article
	*/
	void update(Article article);
	
	/**
	* Method to delete Article
	* @param article Article
	*/
	void delete(Article article);
	
	/**
	* Method to get all Article objects
	* @return List<Article>
	*/
	List<Article> getAllArticles();
	
	/**
	* Method to get all Article objects
	* @param id Integer
	* @return Article
	*/
	Article getArticleById(Integer id);

}
