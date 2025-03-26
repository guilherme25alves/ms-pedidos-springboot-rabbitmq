package br.com.guilherme25alves.processamento;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class ProcessamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessamentoApplication.class, args);
	}

}
