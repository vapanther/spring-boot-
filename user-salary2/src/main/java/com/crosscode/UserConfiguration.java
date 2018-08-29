package com.crosscode;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
    basePackages = "com.crosscode.repository", 
    entityManagerFactoryRef = "userEntityManagerFactory", 
    transactionManagerRef = "userTransactionManager"
)
public class UserConfiguration {
	
	@Bean(name="datasource")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource primaryDataSource() {
	    return DataSourceBuilder.create().build();
	}
	
	@Primary
    @Bean(name = "userEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("datasource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.crosscode.repository")
                .persistenceUnit("userPU")
                .build();
}
	
	 @Primary
	    @Bean(name = "userTransactionManager")
	    public PlatformTransactionManager transactionManager(
	            @Qualifier("userEntityManagerFactory") EntityManagerFactory userEntityManagerFactory) {
	        return new JpaTransactionManager(userEntityManagerFactory);
	    }

}
