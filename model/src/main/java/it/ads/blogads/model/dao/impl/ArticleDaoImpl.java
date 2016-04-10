package it.ads.blogads.model.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.ads.blogads.model.dao.IArticleDao;
import it.ads.blogads.model.entity.Article;

//Segnala che si tratta di una classe DAO (o Repository)
@Repository
// Significa che tutti i metodi della classe sono definiti come @Transactional
@Transactional
public class ArticleDaoImpl implements IArticleDao{
	
	@PersistenceContext
	private EntityManager entitymanager;
	
	public void save(Article article){
		entitymanager.persist(article);
	}
	
	public void update(Article article){
		entitymanager.merge(article);
	}
	
	public void delete(Article article){
		entitymanager.remove(article);
	}
	
	/*
	public Article findByArticleCode(String articleCode){
		[...]
	}
	*/

}
