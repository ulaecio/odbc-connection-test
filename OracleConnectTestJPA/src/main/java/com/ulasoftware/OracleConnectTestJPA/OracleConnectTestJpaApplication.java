package com.ulasoftware.OracleConnectTestJPA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OracleConnectTestJpaApplication implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(OracleConnectTestJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Cliente> listClientes = clienteRepository.findAll();
		
		listClientes.forEach(System.out :: println);
	}

}
