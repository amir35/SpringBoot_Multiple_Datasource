package com.example.demo.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager" ,basePackages = {
"com.example.demo.repository.employee" })
public class EmployeeConfiguration {

	//Datasource method goes here
	@Primary
	@Bean(name="datasource")
	@ConfigurationProperties(prefix = "spring.oracle.datasource")
	public DataSource dataSource(){
	    return DataSourceBuilder.create().build();
	}

	//LocalContainerEntityManagerFactoryBean goes here
	@Primary
	@Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
	        @Qualifier("datasource") DataSource dataSource
	)
	{
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
	    return builder
	            .dataSource(dataSource)
	            .properties(properties)
	            .packages("com.example.demo.entity")
	            .persistenceUnit("Employee")
	            .build();
	}

	//PlatformTransactionManager goes here
	@Primary
	@Bean(name="transactionManager")
	public PlatformTransactionManager transactionManager(
	        @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory
	)
	{
	    return new JpaTransactionManager(entityManagerFactory);
	}

}
