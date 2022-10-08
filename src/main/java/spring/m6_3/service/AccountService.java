package spring.m6_3.service;
/**
 * @author jangle
 * @email jangle@jangle.xyz
 * @time 2022年10月8日 上午9:30:53
 * 
 */
public interface AccountService {
	
	/**
	 * 转账
	 * @author jangle
	 * @time 2022年10月8日 上午10:04:48
	 * @param sourceId
	 * @param targetId
	 * @param amount
	 */
	void transferMoney(long sourceId, long targetId, double amount);

}
