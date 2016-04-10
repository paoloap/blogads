package it.ads.blogads.model.service.impl;

import it.ads.blogads.model.service.ITagManager;
import it.ads.blogads.model.dao.ITagDao;
import it.ads.blogads.model.entity.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class TagManagerImpl implements ITagManager{
	
	@Autowired
	ITagDao tagDao;

	public void save(Tag tag){
		tagDao.save(tag);
	}
	
	public void update(Tag tag){
		tagDao.update(tag);
	}
	
	public void delete(Tag tag){
		tagDao.delete(tag);
	}
	
	/*
	public Tag findByTagCode(String tagCode){
		return tagDao.findByTagCode(tagCode);
	 */
}