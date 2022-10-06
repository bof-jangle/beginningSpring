package spring.dao;

import spring.model.Account;

/**
 * @author jangle
 * @email jangle@jangle.xyz
 * @time 2022年10月6日 下午2:15:59
 * 
 */
public interface AccountDao {
	
	public Account find(long accountId);

}
