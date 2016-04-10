package it.ads.blogads.model.service.impl;

import it.ads.blogads.model.service.IArticleManager;
import it.ads.blogads.model.dao.IArticleDao;
import it.ads.blogads.model.entity.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ArticleManagerImpl implements IArticleManager{
	
	@Autowired
	IArticleDao articleDao;

	public void save(Article article){
		articleDao.save(article);
	}
	
	public void update(Article article){
		articleDao.update(article);
	}
	
	public void delete(Article article){
		articleDao.delete(article);
	}
	
	/*
	public Article findByArticleCode(String articleCode){
		return articleDao.findByArticleCode(articleCode);
	 */
}
