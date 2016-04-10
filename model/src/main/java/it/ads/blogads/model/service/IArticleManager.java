package it.ads.blogads.model.service;

import it.ads.blogads.model.entity.Article;

public interface IArticleManager {
	
	void save(Article stock);
	void update(Article stock);
	void delete(Article stock);
	// Article findByArticleCode(String articleCode);
}

