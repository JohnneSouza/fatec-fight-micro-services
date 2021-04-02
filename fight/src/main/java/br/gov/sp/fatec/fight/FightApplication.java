package br.gov.sp.fatec.fight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FightApplication {

	public static void main(String[] args) {
		SpringApplication.run(FightApplication.class, args);
	}

}
