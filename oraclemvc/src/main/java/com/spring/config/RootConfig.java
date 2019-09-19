package com.spring.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
//@PropertySource("classpath:db.properties")	// <context:property-placeholder location="classpath:db.properties"/>
/*@PropertySource("file:src\\main\\resources\\db.properties")*/
@ComponentScan(basePackages= {"com.spring.service"})	// <context:component-scan base-package="com.spring.service"/>
@MapperScan(basePackages= {"com.spring.mapper"})	// <mybatis-spring:scan base-package="com.spring.mapper"/>
@Transactional	// <tx:annotation-driven/>
public class RootConfig {
	
	//@Value("${driver}")
	@Value("oracle.jdbc.OracleDriver")
	private String driver;
	
	//@Value("${url}")
	@Value("jdbc:oracle:thin:@localhost:1521:orcl")
	private String jdbcUrl;
	
	@Value("scott")
	private String username;
	
	
	@Value("tiger")
	public  String password;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
	
	@Bean
	public DataSource dataSource() {
		HikariDataSource hikari=new HikariDataSource();
		hikari.setDriverClassName(driver);
		hikari.setJdbcUrl(jdbcUrl);
		hikari.setUsername(username);
		hikari.setPassword(password);
		
		System.out.println("username ..."+username);
		System.out.println("password"+password);
		
		HikariDataSource dataSource=new HikariDataSource(hikari);
		return dataSource;
	}
	
	/*
	<bean name="hikariconf" class="com.zaxxer.hikari.HikariConfig">
		<property name="driverClassName" value="${driver}"></property>
		<property name="jdbcUrl" value="${url}"></property>
		<property name="username" value="${username}"></property>
		<property name="password" value="${password}"></property>
	</bean>
	<bean name="hikarids" class="com.zaxxer.hikari.HikariDataSource" destroy-method="close">
		<constructor-arg ref="hikariconf"></constructor-arg>
	</bean>
	*/
	
	@Bean
	public SqlSessionFactoryBean factory() {
		SqlSessionFactoryBean factory=new SqlSessionFactoryBean();
		factory.setDataSource(dataSource());
		factory.setMapperLocations(new Resource[] {new ClassPathResource("mapper/emp.xml")});
		return factory;
	}
	
	/*
	<bean name="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="hikarids"></property>
		<property name="mapperLocations" value="classpath:mapper/*.xml"></property>
	</bean>
	*/
	
	
	@Bean
	public DataSourceTransactionManager transaction(DataSource dataSource) {
		DataSourceTransactionManager transaction=new DataSourceTransactionManager();
		transaction.setDataSource(dataSource);
		
		return transaction;
	}
	
	/*
	<bean name="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="hikarids" />
	</bean>
	*/

}
