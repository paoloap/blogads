package it.ads.blogads.model.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.ads.blogads.model.dao.ITagDao;
import it.ads.blogads.model.entity.Tag;

//Segnala che si tratta di una classe DAO (o Repository)
@Repository
// Significa che tutti i metodi della classe sono definiti come @Transactional
@Transactional
public class TagDaoImpl implements ITagDao{
	
	@PersistenceContext
	private EntityManager entitymanager;
	
	public void save(Tag tag){
		entitymanager.persist(tag);
	}
	
	public void update(Tag tag){
		entitymanager.merge(tag);
	}
	
	public void delete(Tag tag){
		entitymanager.remove(tag);
	}
	
	/*
	public Tag findByTagCode(String tagCode){
		[...]
	}
	*/

}