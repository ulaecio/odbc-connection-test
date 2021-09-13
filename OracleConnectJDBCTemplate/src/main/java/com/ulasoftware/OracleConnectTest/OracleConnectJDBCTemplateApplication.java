package com.ulasoftware.OracleConnectTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class OracleConnectJDBCTemplateApplication implements CommandLineRunner{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(OracleConnectJDBCTemplateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql = "SELECT * FROM cliente";
		List<Cliente> clientes = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Cliente.class));
         
        clientes.forEach(System.out :: println);
	}

}
