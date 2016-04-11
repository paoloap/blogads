package it.ads.blogads.model.dao;

import it.ads.blogads.model.entity.Tag;

/**
 * Interface DAO Service for entity Tag
 * @author Paolo Porcedda
 */
public interface ITagDao {
	
	/**
	* Method to save Tag
	* @param tag Tag
	*/
	void save(Tag tag);
	
	/**
	* Method to update Tag
	* @param tag Tag
	*/
	void update(Tag tag);
	
	/**
	* Method to delete Tag
	* @param tag Tag
	*/
	void delete(Tag tag);

}