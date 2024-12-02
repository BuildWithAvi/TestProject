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
//import javax.sql.DataSource;
//
//@EnableTransactionManagement
//@Configuration
//@EnableJpaRepositories(
//        basePackages = "com.example.db.repository.secondary",
//        entityManagerFactoryRef = "secondaryEntityManagerFactory",
//        transactionManagerRef = "secondaryTransactionManager"
//)
//@EntityScan(basePackages = "com.example.db.entity.secondary")
//public class SecondaryDataSourceConfig {
//
//    @Bean(name = "secondaryDataSource")
//    public DataSource secondaryDataSource() {
//        return DataSourceBuilder.create()
//                .url("jdbc:postgresql://localhost:5433/secondary_db")
//                .username("postgres")
//                .password("avinash1910")
//                .driverClassName("org.postgresql.Driver")
//                .build();
//    }
//
////    @Bean(name = "secondaryEntityManagerFactory")
////    public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(
////            @Qualifier("secondaryDataSource") DataSource dataSource) {
////        return new LocalContainerEntityManagerFactoryBean() {{
////            setDataSource(dataSource);
////            setPackagesToScan("com.example.db.entity.secondary");
////            setPersistenceUnitName("secondary");
////        }};
////    }
//
//    @Bean(name = "secondaryEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(
//            @Qualifier("secondaryDataSource") DataSource dataSource) {
//        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        factoryBean.setPackagesToScan("com.example.db.entity.secondary");
//        factoryBean.setPersistenceUnitName("secondary");
//
//        // Specify the JPA provider (Hibernate)
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        factoryBean.setJpaVendorAdapter(vendorAdapter);
//
//        return factoryBean;
//    }
//
//
//    @Bean(name = "secondaryTransactionManager")
//    public PlatformTransactionManager secondaryTransactionManager(
//            @Qualifier("secondaryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//}