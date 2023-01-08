package com.example.enviar.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.enviar.domain.ReceberJson;
import com.example.enviar.domain.Retorno;
import com.example.enviar.transport.Comunicacao;
import com.example.enviar.utils.Utils;

@Controller
public class TodoController {

	@GetMapping("/enviarservice")
	@ResponseBody
	public String index() {
		
		System.out.println(Utils.daHoraLog() + "Serviço disponível: Status OK");
		
		return "api";
	}
	
	@GetMapping("/enviarservice/valida")
	@ResponseBody
	public Map<String, String> versao() {
		
		System.out.println(Utils.daHoraLog() + "API: Status OK");
		
		HashMap<String, String> map = new HashMap<>();
		
		map.put("app", "enviarService");
		map.put("now", new Date().toString());
		
		return map;
		
	}
	
	@GetMapping("/enviarservice/comunicacao")
	@ResponseBody
	public Retorno comunicacao() {
		
		System.out.println(Utils.daHoraLog() + "[TodoController.comunicacao] - INICIO");
		Retorno retorno = new Retorno();
		
		retorno.setCodRetorno(10);
		retorno.setMsgRetorno("INICIADO");
		
		try {
			String ret = Comunicacao.chamarIndex();
					
			retorno.setCodRetorno(0);
			retorno.setMsgRetorno(ret);
		} catch (Exception e) {
			retorno.setCodRetorno(1);
			retorno.setMsgRetorno("ERRO NA CHAMADA");
		}
		
		return retorno;
	}
	
	@GetMapping("/enviarservice/montareceber")
	@ResponseBody
	public Retorno chamarMontaRecebimento() {
		
		System.out.println(Utils.daHoraLog() + "[TodoController.chamarMontaRecebimento] - INICIO MONTA");
		
		Retorno retorno = new Retorno();
		
		try {
			ReceberJson[] ret = Comunicacao.chamarComunicacaoMonta();
					
			retorno.setCodRetorno(0);
			retorno.setMsgRetorno("Qtd Retorno: " +ret.length + " | " + ret[0].getDataHoraAtual());
			
		} catch (Exception e) {
			retorno.setCodRetorno(1);
			retorno.setMsgRetorno("ERRO NA CHAMADA");
		}
		
		return retorno;
	}
	
	@GetMapping("/enviarservice/enviareceber")
	@ResponseBody
	public Retorno chamarEnviaRecebimento() {
		
		System.out.println(Utils.daHoraLog() + "[TodoController.chamarEnviaRecebimento] - INICIO MONTA");
		Retorno retorno = new Retorno();
		
		try {
			ReceberJson[] ret = Comunicacao.chamarComunicacaoEnvia();
					
			retorno.setCodRetorno(0);
			retorno.setMsgRetorno("Qtd Retorno: " + ret.length + " - Dados: " +ret[0].getDados() + " | " + ret[0].getDataHoraAtual());
			
		} catch (Exception e) {
			retorno.setCodRetorno(1);
			retorno.setMsgRetorno("ERRO NA CHAMADA");
		}
		
		return retorno;
	}
}
