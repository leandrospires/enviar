package com.example.enviar.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReceberJson {

	@JsonProperty("cod")
	private int cod;
	
	@JsonProperty("dados")
	private String dados;
	
	@JsonProperty("dataHoraAtual")
	private String dataHoraAtual;

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDados() {
		return dados;
	}

	public void setDados(String dados) {
		this.dados = dados;
	}

	public String getDataHoraAtual() {
		return dataHoraAtual;
	}

	public void setDataHoraAtual(String dataHoraAtual) {
		this.dataHoraAtual = dataHoraAtual;
	}
	
}