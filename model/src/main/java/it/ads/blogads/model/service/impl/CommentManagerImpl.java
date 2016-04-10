package it.ads.blogads.model.service.impl;

import it.ads.blogads.model.service.ICommentManager;
import it.ads.blogads.model.dao.ICommentDao;
import it.ads.blogads.model.entity.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CommentManagerImpl implements ICommentManager{
	
	@Autowired
	ICommentDao commentDao;

	public void save(Comment comment){
		commentDao.save(comment);
	}
	
	public void update(Comment comment){
		commentDao.update(comment);
	}
	
	public void delete(Comment comment){
		commentDao.delete(comment);
	}
	
	/*
	public Comment findByCommentCode(String commentCode){
		return commentDao.findByCommentCode(commentCode);
	 */
}