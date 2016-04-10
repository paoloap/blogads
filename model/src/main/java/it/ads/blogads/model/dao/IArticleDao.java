package it.ads.blogads.model.dao;

import it.ads.blogads.model.entity.Article;

/**
 * Interface DAO Service for entity Article
 * @author Paolo Porcedda
 */
public interface IArticleDao {
	
	/**
	* Method to save Article
	* @param article Article
	* @return void
	*/
	void save(Article article);
	
	/**
	* Method to update Article
	* @param article Article
	* @return void
	*/
	void update(Article article);
	
	/**
	* Method to delete Article
	* @param article Article
	* @return void
	*/
	void delete(Article article);
	
	// Article findByArticleCode(String articleCode);

}
