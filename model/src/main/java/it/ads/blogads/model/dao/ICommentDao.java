package it.ads.blogads.model.dao;

import it.ads.blogads.model.entity.Comment;

/**
 * Interface DAO Service for entity Comment
 * @author Paolo Porcedda
 */
public interface ICommentDao {
	
	/**
	* Method to save Comment
	* @param comment Comment
	* @return void
	*/
	void save(Comment comment);
	
	/**
	* Method to update Comment
	* @param comment Comment
	* @return void
	*/
	void update(Comment comment);
	
	/**
	* Method to delete Comment
	* @param comment Comment
	* @return void
	*/
	void delete(Comment comment);
	
	// Comment findByCommentCode(String commentCode);

}