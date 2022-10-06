package spring;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author jangle
 * @email jangle@jangle.xyz
 * @time 2022年10月6日 下午4:09:16
 * 
 */
@Configuration
public class TestConfiguration {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/demo?characterEncoding=UTF8");
		dataSource.setUsername("jangle_demo");
		dataSource.setPassword("1");
		return dataSource;
	}

}
