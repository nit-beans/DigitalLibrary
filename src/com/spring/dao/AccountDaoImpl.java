package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.model.Account;


public class AccountDaoImpl implements AccountDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Account> list(int userId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		 String sql = "SELECT * FROM orders where userId=" +userId;
		    List<Account> orderlist = jdbcTemplate.query(sql, new RowMapper<Account>() {
		 
		        @Override
		        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		            Account aorder = new Account();
		           
		            aorder.setId(rs.getInt("Id"));
		            aorder.setUserId(rs.getInt("userId"));
		           aorder.setEmailId(rs.getString("emailId"));
		            aorder.setBookName(rs.getString("BookName"));
		            aorder.setStatus(rs.getString("Status"));
		            aorder.setTimestamp(rs.getString("Timestamp"));
		           
		 
		            return aorder;
		        }
		        
		 
		    });
		    
			
		    return orderlist;
	}

}
