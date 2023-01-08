package com.example.enviar.transport;

import org.springframework.web.client.RestTemplate;

import com.example.enviar.domain.ReceberJson;
import com.example.enviar.utils.Utils;

public class Comunicacao {
	

	public static String chamarIndex() {
		
		String uri = "http://localhost:8080/receberservice";
		
		RestTemplate restTemplate = new RestTemplate();
		
		String result = restTemplate.getForObject(uri, String.class);
		
		return result;
	}

	public static ReceberJson[] chamarComunicacaoMonta() {
		
		ReceberJson[] arrayList = null;
		
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:8080/receberservice/recebermontajson";
		
		try {
			
			arrayList = restTemplate.getForObject(uri, ReceberJson[].class);
			
		} catch (Exception e) {
			System.out.println(Utils.daHoraLog() + " - ERRO NA CHAMADA");
			System.out.println(Utils.daHoraLog() + " - ERRO: " +e.getMessage() );
		}
		
		return arrayList;
	}
	
	public static ReceberJson[] chamarComunicacaoEnvia() {
		
		ReceberJson receberJson = new ReceberJson();
		ReceberJson[] arrayList = null;
		
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:8080/receberservice/receberenviajson";
		
		try {
			receberJson.setCod(220);
			receberJson.setDados("chamando via enviar");
			arrayList = restTemplate.postForObject(uri, receberJson, ReceberJson[].class);
			
		} catch (Exception e) {
			System.out.println(Utils.daHoraLog() + " - ERRO NA CHAMADA");
			System.out.println(Utils.daHoraLog() + " - ERRO: " +e.getMessage() );
		}
		
		return arrayList;
	}
	
//	public static ReceberJson chamarComunicacaoMonta() {
//		
//		RestTemplate restTemplate = new RestTemplate();
//		String uri = "http://localhost:8080/receberservice/recebermontajson";
//		
//		ReceberJson resultList = new ReceberJson();
//		
//		try {
//			
//			resultList = restTemplate.getForObject(uri, ReceberJson.class);
//			
//		} catch (Exception e) {
//			System.out.println(Utils.daHoraLog() + " - ERRO NA CHAMADA");
//			System.out.println(Utils.daHoraLog() + " - ERRO: " +e.getMessage() );
//		}
//		
//		return resultList;
//	}

}
