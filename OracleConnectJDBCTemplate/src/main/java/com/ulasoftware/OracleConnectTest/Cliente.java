package com.ulasoftware.OracleConnectTest;

public class Cliente {
	
	private int cli_id;
	private String cli_razao_social;
	public int getCli_id() {
		return cli_id;
	}
	public void setCli_id(int cli_id) {
		this.cli_id = cli_id;
	}
	public String getCli_razao_social() {
		return cli_razao_social;
	}
	public void setCli_razao_social(String cli_razao_social) {
		this.cli_razao_social = cli_razao_social;
	}
	@Override
	public String toString() {
		return "Cliente [cli_id=" + cli_id + ", cli_razao_social=" + cli_razao_social + "]";
	}
	
	
	
	
}
