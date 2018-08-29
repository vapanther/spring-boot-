package com.crosscode;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author ankit.tripathi
 * 
 * JPA Entity Manager Factory Configuration Class
 *
 */
@Configuration
@EnableJpaRepositories(
    basePackages = "com.crosscode.salrepository", 
    entityManagerFactoryRef = "usersalEntityManagerFactory", 
    transactionManagerRef = "usersalTransactionManager"
)
public class SalaryConfiguration {
	
	@Bean(name="secondryDatasource")
	@ConfigurationProperties(prefix="spring.secondDatasource")
	public DataSource secondaryDataSource() {
	    return DataSourceBuilder.create().build();
	}
	
	 @Bean(name = "usersalEntityManagerFactory")
	    public LocalContainerEntityManagerFactoryBean usersalEntityManagerFactory(
	            EntityManagerFactoryBuilder builder,
	            @Qualifier("secondryDatasource") DataSource secondryDatasource) {
	        return builder
	                .dataSource(secondryDatasource)
	                .packages("com.crosscode.salrepository")
	                .persistenceUnit("usersalPU")
	                .build();
	}
	 

	    @Bean(name = "usersalTransactionManager")
	    public PlatformTransactionManager usersalTransactionManager(
	            @Qualifier("usersalEntityManagerFactory") EntityManagerFactory usersalEntityManagerFactory) {
	        return new JpaTransactionManager(usersalEntityManagerFactory);
	    }

}
