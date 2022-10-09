package spring.dao;

import java.util.List;

import spring.model.TableA;

/**
 * @author jangle
 * @email jangle@jangle.xyz
 * @time 2022年10月6日 下午2:15:59
 * 
 */
public interface AccountDao {
	
	public TableA find(long accountId);
	/**
	 * 使用preparedStatement 进行查询
	 * 
	 * @author jangle
	 * @time 2022年10月9日 下午2:02:34
	 * @param name
	 * @return
	 */
	public List<TableA> find(String name);
	
}
