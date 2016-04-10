package it.ads.blogads.model.service;

import it.ads.blogads.model.entity.Tag;

public interface ITagManager {
	
	void save(Tag stock);
	void update(Tag stock);
	void delete(Tag stock);
	// Tag findByTagCode(String tagCode);
}