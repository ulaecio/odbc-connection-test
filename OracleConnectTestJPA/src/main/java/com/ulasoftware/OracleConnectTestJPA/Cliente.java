package com.ulasoftware.OracleConnectTestJPA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@Column(name = "cli_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cli_razao_social;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCli_razao_social() {
		return cli_razao_social;
	}
	public void setCli_razao_social(String cli_razao_social) {
		this.cli_razao_social = cli_razao_social;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cli_razao_social=" + cli_razao_social + "]";
	}
	
	

}
