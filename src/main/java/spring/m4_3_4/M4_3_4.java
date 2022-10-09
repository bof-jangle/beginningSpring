package spring.m4_3_4;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.dao.AccountDao;
import spring.m4_2_2.Configuration4_2_2;
import spring.model.TableA;

/**
 * 
 * 在jdbcTemplate中使用prepareStatement
 * @author jangle
 * @email jangle@jangle.xyz
 * @time 2022年10月9日 下午2:19:38
 * 
 */
public class M4_3_4 {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(Configuration4_2_2.class);
		AccountDao dao = applicationContext.getBean(AccountDao.class);
		List<TableA> list = dao.find("名称");
		System.out.println(list.size());
		for(TableA a:list) {
			System.out.println(a.getId());
			System.out.println(a.getName());
		}

	}

}
