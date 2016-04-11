package it.ads.blogads.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	
	@Override
	public void save(Article article){
		entitymanager.persist(article);
	}
	
	@Override
	public void update(Article article){
		entitymanager.merge(article);
	}
	
	@Override
	public void delete(Article article){
		entitymanager.remove(article);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<Article> getAllArticles() {
		String SELECT = " SELECT * "
					+	" FROM Article";
		Query query = entitymanager.createQuery(SELECT);
		try {
			return (List) query.getResultList();
		} catch (ClassCastException cpe) {
			System.out.println(cpe.getMessage()	+	"La query non ha restituito una lista di "
												+	"oggetti Article, quindi va corretta.");
			return null;
		}
	}
	
	public Article getArticleById(Integer id) {
		return (Article) entitymanager.find(Article.class, id);
	}
	
	/*
	@Override
	public Article getArticleById(Integer id) {
		String SELECT =	"SELECT *"
					+	"FROM Article"
					+	"WHERE ARTICLE_ID LIKE :articleId";
		Query query = entitymanager.createQuery(SELECT)
				.setParameter("articleId", id);
		try {
		return (Article) query.getResultList().get(0);
		} catch (NullPointerException npe) {
			System.out.println(npe.getMessage()	+	"La query non ha resituito risultati. Forse "
												+	"l'ID inserito non è corretto.");
			return null;
		} catch (ClassCastException cce) {
			System.out.println(cce.getMessage()	+	"La query non ha restituito un oggetto di "
												+	"tipo Article, quindi va corretta.");
			return null;
		}
	}
	*/
}
