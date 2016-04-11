package it.ads.blogads.model.dao.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import it.ads.blogads.model.config.test.TestModelConfig;
import it.ads.blogads.model.dao.IArticleDao;
import it.ads.blogads.model.entity.Article;
/**
* JUnit Test of DAO Service for entity Article
*
* @author Paolo Porcedda
*
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestModelConfig.class)
@ActiveProfiles("test")
public class ArticleDaoImplTest {
	
	
	
	@Autowired
	private IArticleDao aArticleDao;
	
	@Test
	public void testGetArticles() {
		List<Article> aArticles = aArticleDao.getAllArticles();
		Assert.assertNotNull(aArticles);
		if(!aArticles.isEmpty()) {
			Article aArticle = aArticleDao.getArticleById(aArticles.get(0).getId());
			Assert.assertNotNull(aArticle);
			Assert.assertEquals(aArticles.get(0).getId(),aArticle.getId());
		}
	}
}