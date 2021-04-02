package br.gov.sp.fatec.villain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class VillainApplication {

	public static void main(String[] args) {
		SpringApplication.run(VillainApplication.class, args);
	}

}
