package spring.m4_2_2;
/**
 * @author jangle
 * @email jangle@jangle.xyz
 * @time 2022年10月7日 上午7:14:02
 * 
 */

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import spring.dao.AccountDao;
import spring.dao.impl.AccountDaoJdbcImpl;

@Configuration
public class Configuration4_2_2 {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/demo?characterEncoding=UTF8");
		dataSource.setUsername("jangle_demo");
		dataSource.setPassword("1");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}
	
	@Bean
	public AccountDao accountDao() {
		AccountDaoJdbcImpl accountDao = new AccountDaoJdbcImpl();
		accountDao.setJdbcTemplate(jdbcTemplate());
		return accountDao;
	}

}
