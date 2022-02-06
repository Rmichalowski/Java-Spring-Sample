package com.michalowski.Projekt;

import com.michalowski.Projekt.service.CpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjektApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjektApplication.class, args);

	}

	@Bean
	public CommandLineRunner initializeApp(@Autowired CpuService cpuService) {
		return (args) -> cpuService.initializeDB();
	}


}
