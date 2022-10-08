package spring.m6_3.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.annotation.Transactional;

import spring.m6_3.service.AccountService;

/**
 * @author jangle
 * @email jangle@jangle.xyz
 * @time 2022年10月8日 上午9:36:41
 * 
 */
public class AccountServiceJdbcTxImplWithSpring implements AccountService{
	
	private DataSource dataSource;

	@Override
	@Transactional
	public void transferMoney(long sourceId,long targetId,double amount) {
		// 必须使用DataSourceUtils来获取连接，否则无法使用事务功能。
		Connection connection = DataSourceUtils.getConnection(dataSource);
		try {
			//如果使用普通的连接，那么转账后异常时，转账依旧生效（不会回滚）
//			Connection connection = dataSource.getConnection(); 
			Statement statement = connection.createStatement();
			statement.executeUpdate("update table_a set balance = balance - "+amount+" where "
					+ "id = "+ sourceId);
			statement.executeUpdate("update table_a set balance = balance + "+amount+" where "
					+ "id = "+ targetId);
//			throw new RuntimeException(); // 如果在此处添加异常，则上面的SQL转账功能将会不生效（会回滚）。
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally {
			DataSourceUtils.releaseConnection(connection, dataSource);
		}
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}




}
