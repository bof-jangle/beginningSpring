package spring.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;

import spring.dao.AccountDao;
import spring.model.TableA;

/**
 * @author jangle
 * @email jangle@jangle.xyz
 * @time 2022年10月6日 下午2:18:34
 * 
 */
public class AccountDaoJdbcImpl implements AccountDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public TableA find(long accountId) {
		return jdbcTemplate.queryForObject("select id,name,age,address from table_a where id = ?", 
				new RowMapper<TableA>() {
					@Override
					public TableA mapRow(ResultSet rs, int rowNum) throws SQLException {
						TableA a = new TableA();
						a.setId(rs.getLong("id"));
						a.setName(rs.getString("name"));
						a.setAge(rs.getLong("age"));
						a.setAddress(rs.getString("address"));
						return a;
					}
		}, accountId);
	}
	
	
	
	@Override
	public List<TableA> find(String name) {
		// 1.首先创建PreparedStatementCreatorFactory工厂
		PreparedStatementCreatorFactory psCreatorFactory = 
				new PreparedStatementCreatorFactory("select * from table_a where name = ?",
				new int[] {Types.VARCHAR});
		
		return jdbcTemplate.query(psCreatorFactory.newPreparedStatementCreator(new Object[] {name}), 
				new RowMapper<TableA>() {
			
					@Override
					public TableA mapRow(ResultSet rs, int rowNum) throws SQLException {
						TableA a = new TableA();
						a.setId(rs.getLong("id"));
						a.setName(rs.getString("name"));
						a.setAge(rs.getLong("age"));
						a.setAddress(rs.getString("address"));
						a.setBalance(rs.getLong("balance"));
						return a;
					}
		});
	}



	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	

}
