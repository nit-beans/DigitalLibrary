package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;



import com.spring.model.User;

public class UserDaoImpl implements UserDao{
	

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void register(User user){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "Insert into users(firstName,lastName,emailId,passwd,cpassword)values (?,?,?,?,?)";
    jdbcTemplate.update(sql,user.getFirstName(),user.getLastName(),user.getEmailId(),user.getPassword(),user.getCpassword());
        
        String sql2= "Insert into login(emailId,passwd)values(?,?)";
        jdbcTemplate.update(sql2,user.getEmailId(),user.getPassword());
	}

	@Override
	public User get(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM users WHERE id=" + id;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {
	 
	        @Override
	        public User extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                User user=new User();
	                user.setId(rs.getInt("id"));
	                user.setFirstName(rs.getString("firstName"));
	                user.setLastName(rs.getString("lastName"));
	                user.setEmailId(rs.getString("emailId"));
	                user.setPassword(rs.getString("password"));
	                user.setCpassword(rs.getString("cpassword"));
	               
	                return user;
	            }
	 
	            return null;
	        }
	 
	    });
	}
	
	
}
