package spring.m4_2_2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.dao.AccountDao;
import spring.model.TableA;

/**
 *  使用JdbcTemplate进行数据库查询
 * 
 * @author jangle
 * @email jangle@jangle.xyz
 * @time 2022年10月7日 上午7:23:48
 * 
 */
public class M4_2_2 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(Configuration4_2_2.class);
		AccountDao accountDao = applicationContext.getBean(AccountDao.class);
		TableA a = accountDao.find(1L);
		System.out.println(a.getId());
		System.out.println(a.getName());
		System.out.println(a.getAge());
		System.out.println(a.getAddress());
		

	}

}
