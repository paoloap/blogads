package it.ads.blogads.model.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import it.ads.blogads.model.dao.IArticleDao;
import it.ads.blogads.model.dao.ICommentDao;
import it.ads.blogads.model.dao.ITagDao;
import it.ads.blogads.model.dao.impl.ArticleDaoImpl;
import it.ads.blogads.model.dao.impl.CommentDaoImpl;
import it.ads.blogads.model.dao.impl.TagDaoImpl;
import it.ads.blogads.model.service.IArticleManager;
import it.ads.blogads.model.service.ICommentManager;
import it.ads.blogads.model.service.ITagManager;
import it.ads.blogads.model.service.impl.ArticleManagerImpl;
import it.ads.blogads.model.service.impl.CommentManagerImpl;
import it.ads.blogads.model.service.impl.TagManagerImpl;

/**
 * Class for Annotation Type Configuration
 * @author Paolo Porcedda
 *
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = { "it.ads.blogads.model" })
@Profile("production")
public class ModelConfig {
	@Autowired
	private Environment env;
	
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
	public IArticleManager getArticleBo() {  
		return new ArticleManagerImpl();  
	}
	@Bean(name="commentManager")  
	public ICommentManager getCommentBo() {  
		return new CommentManagerImpl();  
	}
	@Bean(name="tagManager")
	public ITagManager getTagBo() {  
		return new TagManagerImpl();  
	}

	
	/*
	 * Data Source Bean: quando viene chiamato il metodo dataSource(), questo ritorna
	 * un oggetto di tipo DriverManagerDataSource con le caratteristiche del nostro DB.
	 */
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(env.getRequiredProperty("db.jdbcurl"), env.getRequiredProperty("db.username"),env.getRequiredProperty("db.password"));
		dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
		return dataSource;
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
        em.setPackagesToScan(new String[]{"it.ads.blogads.model.entity"}); // package where are the @Entity classes are located, ususaly your domain package
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter(); // JPA implementation 
        em.setJpaVendorAdapter(vendorAdapter);
        em.setPersistenceUnitName("prodPU");
        return em;
    }
	
	/*
	 * Transaction Manager: permette di rendere tali i metodi
	 * nelle classi @Transactional (o i singoli metodi @Transactional)
	 */
	@Bean
	@Autowired
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(emf);
        return jpaTransactionManager;
	}
	
	// Fine configurazione Entity Manager //

}