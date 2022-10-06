package spring;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring入门经典4.2.1 
 *  2022年10月6日 16点23分
 * @author jangle
 * @email jangle@jangle.xyz
 * @time 2022年2月18日 下午5:10:06
 * 
 */
public class M4_2 {

	public static void main(String[] args) throws SQLException {
		
		
		
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
//		ctx.getBean(name)
		
		
		
		AnnotationConfigApplicationContext ap =
		new AnnotationConfigApplicationContext(TestConfiguration.class);
		DataSource dataSource = ap.getBean("dataSource", DataSource.class);
		Connection connection = dataSource.getConnection();
		System.out.println(connection.isClosed());
		connection.close();
		System.out.println(connection.isClosed());
		ap.close();
		
	}

}
