package com.goott.eco.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableScheduling
@ComponentScan(basePackages = {"com.goott.eco"})
@MapperScan(basePackages= {"com.goott.eco.mapper"})
public class RootConfig {
	
	//todo. db.properties로 주입 
	private String jdbcUrl = "jdbc:log4jdbc:oracle:thin:@studydb.csm9yowkmr1i.ap-northeast-2.rds.amazonaws.com:1521:orcl";
	private String jdbcUserName = "eco";
	private String jdbcDriver = "net.sf.log4jdbc.sql.jdbcapi.DriverSpy";
	private String jdbcPassword = "eco123456789";
	
//	@Value("${db.driver}") private String jdbcDriver;
//	@Value("${db.url}") private String jdbcUrl;
//	@Value("${db.username}") private String jdbcUserName;
//	@Value("${db.password}") private String jdbcPassword;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		configurer.setLocation(new ClassPathResource("db.properties"));
		return configurer;
	}
	
	/*Connection pool*/
	@Bean//(initMethod="init")
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName(jdbcDriver);
		hikariConfig.setJdbcUrl(jdbcUrl);
		hikariConfig.setUsername(jdbcUserName);
		hikariConfig.setPassword(jdbcPassword);
		hikariConfig.setMaximumPoolSize(3); //자원줄이기

		
		return new HikariDataSource(hikariConfig);
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		
		Resource resource = new ClassPathResource("com/goott/eco/mapper/MybatisConfig.xml");
		sqlSessionFactory.setConfigLocation(resource);
		
		return (SqlSessionFactory)sqlSessionFactory.getObject();
	}
	
	@Bean
	public DataSourceTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
