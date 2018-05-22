package com.SpringMySQLDB.Demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("mysql")
public class UserDataAccessImp implements UserDataAccess{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private static class userRowMapper implements RowMapper<users>{

		@Override
		public users mapRow(ResultSet resultSet, int i) throws SQLException {
			users user = new users();
			
			user.setId(resultSet.getInt("id"));
			user.setName(resultSet.getString("name"));
			user.setAge(resultSet.getInt("age"));
			return user;
		}
		
	}

	@Override
	public Collection<users> getAllUsers() {
		String sql = "SELECT id, name, age FROM users";
		List<users> user = jdbcTemplate.query(sql , new userRowMapper());
		return user;
	}

	@Override
	public users getUserById(int id) {
		String sql = "SELECT id, name, age FROM users WHERE id = ?";
		users user = jdbcTemplate.queryForObject(sql, new userRowMapper(), id);
		return user;
	}

	@Override
	public void deleteUser(int userId) {
		final String sql = "DELETE FROM users WHERE id =? ";
		jdbcTemplate.update(sql, userId);
		
	}

	@Override
	public void updateUser(users usr) {
		final String sql = "UPDATE users SET name =? , age = ? WHERE id = ?";
		int id = usr.getId();
		String name = usr.getName();
		int age = usr.getAge();
		jdbcTemplate.update(sql, new Object[] {name, age, id});
		
	}

	@Override
	public void insertUser(users usr) {
		final String sql = "INSERT INTO users (name, age) VALUES (?, ?) ";
		String name = usr.getName();
		int age = usr.getAge();
		jdbcTemplate.update(sql, new Object[] {name, age});
	}
	

}
