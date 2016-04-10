package it.ads.blogads.model.service;

import it.ads.blogads.model.entity.Comment;

public interface ICommentManager {
	
	void save(Comment stock);
	void update(Comment stock);
	void delete(Comment stock);
	// Comment findByCommentCode(String commentCode);
}