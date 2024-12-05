package io.d4rkr0n1n.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NotesFrontendApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotesFrontendApplication.class, args);
	}

}
