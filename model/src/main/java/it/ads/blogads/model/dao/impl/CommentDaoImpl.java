package it.ads.blogads.model.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.ads.blogads.model.dao.ICommentDao;
import it.ads.blogads.model.entity.Comment;

// Segnala che si tratta di una classe DAO (o Repository)
@Repository
// Significa che tutti i metodi della classe sono definiti come @Transactional
@Transactional
public class CommentDaoImpl implements ICommentDao{
	
	@PersistenceContext
	private EntityManager entitymanager;
	
	public void save(Comment comment){
		entitymanager.persist(comment);
	}
	
	public void update(Comment comment){
		entitymanager.merge(comment);
	}
	
	public void delete(Comment comment){
		entitymanager.remove(comment);
	}
	
	/*
	public Comment findByCommentCode(String commentCode){
		[...]
	}
	*/

}