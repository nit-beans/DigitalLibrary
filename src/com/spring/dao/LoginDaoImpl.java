package com.spring.dao;

import javax.sql.DataSource;

//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;


import com.spring.model.Login;

public class LoginDaoImpl implements LoginDao {
	
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public boolean authenticate(Login login){
		boolean userExists= false;
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		String sql = "Select count(*) from login where emailId= :emailId and passwd= :password ";
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(login);
    int rowCount =jdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
    if(rowCount==1){
    	userExists= true;
    }
    return userExists;
	}
	
	public boolean adminLogin(Login login) {
		boolean userExists= false;
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		String sql = "Select count(*) from admin where emailId= :emailId and passwd= :password ";
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(login);
    int rowCount =jdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
    if(rowCount==1){
    	userExists= true;
    }
    return userExists;
	
	}

	@Override
	public int getId(Login login) {
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		String sql = "Select id from login where emailId= :emailId  ";
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(login);
    int id =jdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
 
    return id;

	}
}

