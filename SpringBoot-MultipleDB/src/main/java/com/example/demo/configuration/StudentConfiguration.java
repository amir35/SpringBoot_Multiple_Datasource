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
@EnableJpaRepositories(entityManagerFactoryRef = "studentEntityManagerFactory", 
						transactionManagerRef = "studentTransactionManager", 
						basePackages = {
										"com.example.demo.repository.student"
										})
public class StudentConfiguration {

	//Datasource method goes here
		@Bean(name="studentdatasource")
		@ConfigurationProperties(prefix = "spring.mysql.datasource")
		public DataSource dataSource(){
		    return DataSourceBuilder.create().build();
		}

		//LocalContainerEntityManagerFactoryBean goes here
		@Bean(name="studentEntityManagerFactory")
		public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
		        @Qualifier("studentdatasource") DataSource dataSource
		)
		{
			Map<String, Object> properties = new HashMap<String, Object>();
			properties.put("hibernate.hbm2ddl.auto", "update");
			properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		    return builder
		            .dataSource(dataSource)
		            .properties(properties)
		            .packages("com.example.demo.entity")
		            .persistenceUnit("Student")
		            .build();
		}

		//PlatformTransactionManager goes here
		@Bean(name="studentTransactionManager")
		public PlatformTransactionManager transactionManager(
		        @Qualifier("studentEntityManagerFactory") EntityManagerFactory entityManagerFactory
		)
		{
		    return new JpaTransactionManager(entityManagerFactory);
		}

}
