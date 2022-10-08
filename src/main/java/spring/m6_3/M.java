 package spring.m6_3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.m6_3.service.AccountService;

/**
 * 
 *  6.3、使用Spring的声明式事务管理（DEMO）。
 * @author jangle
 * @email jangle@jangle.xyz
 * @time 2022年10月8日 上午10:08:50
 * 
 */
public class M {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuration6_3.class);
		AccountService accountService = context.getBean(AccountService.class);
		accountService.transferMoney(1L, 2L, 5.0d);
		System.out.println("完成转账。");
	}

}
