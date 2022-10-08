package spring.m6_3;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import spring.m6_3.service.AccountService;
import spring.m6_3.service.impl.AccountServiceJdbcTxImplWithSpring;

/**
 * @author jangle
 * @email jangle@jangle.xyz
 * @time 2022年10月8日 上午9:53:28
 * 
 */
@Configuration
@EnableTransactionManagement
public class Configuration6_3 {
	/**
	 * 配置数据源
	 * 
	 * @author jangle
	 * @time 2022年10月8日 上午11:13:54
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/demo?characterEncoding=UTF8");
		dataSource.setUsername("jangle_demo");
		dataSource.setPassword("1");
		return dataSource;
	}
	
	/**
	 * 	1.必须创建这个事务对象，spring的事务管理功能才可用。
	 *  2.spring通过“类型”自动装配，所以不用担心取名的问题以及配置的问题。
	 * @author jangle
	 * @time 2022年10月8日 上午10:22:18
	 * @return
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		manager.setDataSource(dataSource());
		return manager;
	}
	
	@Bean
	public AccountService accountService() {
		AccountServiceJdbcTxImplWithSpring bean = new AccountServiceJdbcTxImplWithSpring();
		bean.setDataSource(dataSource());
		return bean;
	}

}
