package com.example.db.config;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

import javax.sql.DataSource;

@EnableTransactionManagement
@Configuration
public class DataSourceConfig {

    // Primary Data Source Configuration
    @Configuration
    @EnableJpaRepositories(
            basePackages = "com.example.db.repository.primary",
            entityManagerFactoryRef = "primaryEntityManagerFactory",
            transactionManagerRef = "primaryTransactionManager",
            repositoryImplementationPostfix = "PrimaryRepoImpl"
    )
    @EntityScan(basePackages = "com.example.db.entity")
    @Primary
    public static class PrimaryDataSourceConfig {

        @Bean(name = "primaryDataSource")
        public DataSource primaryDataSource() {
            return DataSourceBuilder.create()
                    .url("jdbc:mysql://localhost:3306/primary_db")
                    .username("root")
                    .password("***")
                    .driverClassName("com.mysql.cj.jdbc.Driver")
                    .build();
        }

        @Bean(name = "primaryEntityManagerFactory")
        public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
                @Qualifier("primaryDataSource") DataSource dataSource) {
            LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
            factoryBean.setDataSource(dataSource);
            factoryBean.setPackagesToScan("com.example.db.entity");
            factoryBean.setPersistenceUnitName("primary");

            HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
            factoryBean.setJpaVendorAdapter(vendorAdapter);

            return factoryBean;
        }

        @Bean(name = "primaryEntityManager")
        public EntityManager primaryEntityManager(
                @Qualifier("primaryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
            return entityManagerFactory.createEntityManager();
        }

        @Bean(name = "primaryTransactionManager")
        public PlatformTransactionManager primaryTransactionManager(
                @Qualifier("primaryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
            return new JpaTransactionManager(entityManagerFactory);
        }
    }

    // Secondary Data Source Configuration
    @Configuration
    @EnableJpaRepositories(
            basePackages = "com.example.db.repository.secondary",
            entityManagerFactoryRef = "secondaryEntityManagerFactory",
            transactionManagerRef = "secondaryTransactionManager",
            repositoryImplementationPostfix = "SecondaryRepoImpl"
    )
    @EntityScan(basePackages = "com.example.db.entity")
    public static class SecondaryDataSourceConfig {

        @Bean(name = "secondaryDataSource")
        public DataSource secondaryDataSource() {
            return DataSourceBuilder.create()
                    .url("jdbc:mysql://localhost:3306/secondary_db")
                    .username("root")
                    .password("***")
                    .driverClassName("com.mysql.cj.jdbc.Driver")
                    .build();
        }

        @Bean(name = "secondaryEntityManagerFactory")
        public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(
                @Qualifier("secondaryDataSource") DataSource dataSource) {
            LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
            factoryBean.setDataSource(dataSource);
            factoryBean.setPackagesToScan("com.example.db.entity");
            factoryBean.setPersistenceUnitName("secondary");

            HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
            factoryBean.setJpaVendorAdapter(vendorAdapter);

            return factoryBean;
        }

        @Bean(name = "secondaryEntityManager")
        public EntityManager secondaryEntityManager(
                @Qualifier("secondaryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
            return entityManagerFactory.createEntityManager();
        }

        @Bean(name = "secondaryTransactionManager")
        public PlatformTransactionManager secondaryTransactionManager(
                @Qualifier("secondaryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
            return new JpaTransactionManager(entityManagerFactory);
        }
    }
}
