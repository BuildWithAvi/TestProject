//package com.example.db.config;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import jakarta.persistence.EntityManagerFactory;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//
//@EnableTransactionManagement
//@Configuration
//@EnableJpaRepositories(
//        basePackages = "com.example.db.repository.primary",
//        entityManagerFactoryRef = "primaryEntityManagerFactory",
//        transactionManagerRef = "primaryTransactionManager"
//)
//@EntityScan(basePackages = "com.example.db.entity.primary")
//public class PrimaryDataSourceConfig {
//
//    @Bean(name = "primaryDataSource")
//    public DataSource primaryDataSource() {
//        return DataSourceBuilder.create()
//                .url("jdbc:mysql://localhost:3306/primary_db")
//                .username("root")
//                .password("avinash1910")
//                .driverClassName("com.mysql.cj.jdbc.Driver")
//                .build();
//    }
//
//    @Bean(name = "primaryEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
//            @Qualifier("primaryDataSource") DataSource dataSource) {
//        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        factoryBean.setPackagesToScan("com.example.db.entity.primary");
//        factoryBean.setPersistenceUnitName("primary");
//
//        // Specify the JPA provider (Hibernate)
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        factoryBean.setJpaVendorAdapter(vendorAdapter);
//
//        return factoryBean;
//    }
//
//    @Bean(name = "primaryTransactionManager")
//    public PlatformTransactionManager primaryTransactionManager(
//            @Qualifier("primaryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//}


