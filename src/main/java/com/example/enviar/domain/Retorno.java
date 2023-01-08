package com.example.enviar.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Retorno {
	
	@JsonProperty("codRetorno")
	private int codRetorno;
	
	@JsonProperty("msgRetorno")
	private String msgRetorno;

	public int getCodRetorno() {
		return codRetorno;
	}

	public void setCodRetorno(int codRetorno) {
		this.codRetorno = codRetorno;
	}

	public String getMsgRetorno() {
		return msgRetorno;
	}

	public void setMsgRetorno(String msgRetorno) {
		this.msgRetorno = msgRetorno;
	}
	
}
