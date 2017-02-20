package oleg.recipe_book.config;


import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Oleg on 19.02.2017.
 */
@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:hibernate.properties"})
public class HibernateConfiguration {
    private static final Logger logger= LoggerFactory.getLogger(HibernateConfiguration.class);
    @Autowired
    Environment environment;

    public HibernateConfiguration(){
        logger.info("Hibernate configuration constructor working");
    }

    @Bean
    LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactoryBean=new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("oleg.recipe_book.model");
        sessionFactoryBean.setHibernateProperties(getHibernateProperties());
        return sessionFactoryBean;
    }

    @Bean
    DataSource dataSource(){
        DriverManagerDataSource dataSource= new DriverManagerDataSource();
        dataSource.setDriverClassName("jdbc.driverClassName");
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    private Properties getHibernateProperties(){
        Properties properties=new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }

}
