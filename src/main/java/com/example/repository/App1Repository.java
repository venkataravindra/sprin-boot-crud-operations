package com.example.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.modal.User;

@Repository
public  class App1Repository {

	@Autowired
    NamedParameterJdbcTemplate template;
	@Autowired
	public void setDataSource(DataSource template) {
        this.template = new NamedParameterJdbcTemplate(template);
	
	}
	 public List<User> getAllUsers(){
	        List<User> users = template.query("select id, firstName,lastName,age,email,username,password,address from user",(result,rowNum)->new User(result.getInt("id"),
	                result.getString("firstName"),result.getString("lastName"),result.getInt("age"),result.getString("email"),result.getString("username"),result.getString("password"),result.getString("address")));
	        return users;
	    }
	 public int deleteUser(int id){
	        String query = "DELETE FROM USER WHERE ID =:id";
	        Map<String, Object> paramMap = new HashMap<String, Object>();
	        paramMap.put("id", id);
			return template.update(query, paramMap);
	    }
	 public int updateUser(User user) {
			String sql ="update USER set firstName=:firstName,lastName=:lastName,age=:age,email=:email,address=:address where id=:id";
			 BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
	         
	        return template.update(sql, params);
		}
	 public int UserCreation(User user) {
		 
		 System.out.println(user);
		 String sql ="INSERT INTO user(id,firstName,lastName,age,email,username,password,address) values(:id,:firstName,:lastName,:age,:email,:username,:password,:address)";
			
		/* Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("id", user.getId());
			paramMap.put("firstname", user.getFirstName());
			paramMap.put("lastName", user.getLastName());
			paramMap.put("age", user.getAge());
			paramMap.put("email", user.getEmail());
			paramMap.put("username", user.getUsername());
			paramMap.put("password", user.getPassword());
			paramMap.put("addrress", user.getAddress());
			 return template.update(sql, paramMap); */
			 BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
	         return template.update(sql, params);
	         
	      /*   SqlParameterSource parameters = new MapSqlParameterSource()
	 				.addValue("id", user.getId()).addValue("firstName", user.getFirstName())
	 				.addValue("lastName", user.getLastName())
	 				.addValue("age",user.getAge())
	 				.addValue("email", user.getEmail())
	 				.addValue("username",user.getUsername())
	 				.addValue("password", user.getPassword())
	 				.addValue("address", user.getAddress());
	       
	         return template.update(sql, parameters);
			*/
			
	 }
	 
	 public List<User> editUser(int id){
		
		 MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("id", id);
		   return template.query("select *from user where id=:id", params, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setAge(rs.getInt("age"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
				
				
				return user;
			}
		});
		 
	 }		 
			 
			 public List<User> login(User user){
				
				 MapSqlParameterSource params = new MapSqlParameterSource();
					params.addValue("username", user.getUsername());
					params.addValue("password", user.getPassword());
				   return template.query("select username,password from user where username=:username and password=:password" , params, new RowMapper<User>() {

					@Override
					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
						User user = new User();
						user.setUsername(rs.getString("username"));
						user.setPassword(rs.getString("password"));
						return user;
					}
				});
				 
		 
		 /*Map parameters = new HashMap();
			parameters.put("id", id);
			
			return (User) template.queryForObject("select * from users where id = :id", new UserMapper());
		 String query = "SELECT * FROM USER WHERE ID=?";
	     User user = template.queryForObject(query,new Object[]{id},new BeanPropertyRowMapper<>(User.class));
	     return template.update(query,id);
	    }*/
}
	 class UserMapper implements RowMapper {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setAge(rs.getInt("age"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
				return user;
			}


}
}