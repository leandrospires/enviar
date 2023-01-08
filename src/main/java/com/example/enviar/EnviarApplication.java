package com.example.enviar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.enviar.utils.Utils;

@SpringBootApplication
public class EnviarApplication {

	public static void main(String[] args) {
		System.out.println(Utils.daHoraLog() + "INICIANDO SPRING BOOT OK");
		SpringApplication.run(EnviarApplication.class, args);
	}

}
