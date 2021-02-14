package com.enigma.ari.tryThymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeesDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Employeess> list() {
		String sql = "SELECT * FROM EMPLOYEESS";

		List<Employeess> listEmployeess = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Employeess.class));

		return listEmployeess;
	}
	
	public void save(Employeess employeess) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("employeess").usingColumns("name", "jabatan", "golongan", "gaji");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(employeess);
		
		insertActor.execute(param);		
	}
	
	public Employeess get(int id) {
		String sql = "SELECT * FROM EMPLOYEESS WHERE id = ?";
		Object[] args = {id};
		Employeess employeess = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Employeess.class));
		return employeess;
	}
	
	public void update(Employeess employeess) {
		String sql = "UPDATE EMPLOYEESS SET name=:name, jabatan=:jabatan, golongan=:golongan, gaji=:gaji WHERE id=:id";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(employeess);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);		
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM EMPLOYEESS WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
}
