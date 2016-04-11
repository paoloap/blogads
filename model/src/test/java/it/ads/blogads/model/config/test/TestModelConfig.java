package it.ads.blogads.model.config.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import it.ads.blogads.model.dao.IArticleDao;
import it.ads.blogads.model.dao.ICommentDao;
import it.ads.blogads.model.dao.ITagDao;
import it.ads.blogads.model.dao.impl.ArticleDaoImpl;
import it.ads.blogads.model.dao.impl.CommentDaoImpl;
import it.ads.blogads.model.dao.impl.TagDaoImpl;

/**
* Class for Annotation Type Configuration
* @author Paolo Porcedda
*
*/
@Configuration
@ComponentScan(basePackages = { "it.ads.blogads.model" })
@Profile("test")
public class TestModelConfig {
	
	@Bean
	public IArticleDao getArticleDao() {  
		return new ArticleDaoImpl();  
	}
	@Bean
	public ICommentDao getCommentDao() {  
		return new CommentDaoImpl();  
	}
	@Bean
	public ITagDao getTagDBoao() {  
		return new TagDaoImpl();  
	}
	
	@Bean
	public EmbeddedDatabase dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL)
				.addScript("classpath:sql/init_datatables_test.sql")
				.addScript("classpath:sql/empty_db.sql")
				.addScript("classpath:sql/create_test_tables.sql")
				.build();
		return db;
	}
	
	// Configurazione Entity Manager //
	
	/*
	 * Entity Manager Factory: permette l'iniezione dei proxy Entity Manager
	 */
	@Bean
	@Autowired
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[]{"it.ads.blogads.model"}); // package where are the @Entity classes are located, ususaly your domain package
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter(); // JPA implementation 
        em.setJpaVendorAdapter(vendorAdapter);
        em.setPersistenceUnitName("testPU");
        return em;
    }
}