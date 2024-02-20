package com.example.beansComponet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeansComponetApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeansComponetApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ConversorJson conversorJson) throws Exception {
		return args -> {
			String json = "{\"cep\": \"01001-000\",\"logradouro\": \"Praça da Sé\",\"localidade\": \"São Paulo\"}";
		ViaCepResponse response = conversorJson.converter(json);
			System.out.println("Dados do CEP: " + response);
		};
	}

}

//		- Se usa @Component sempre que se tem acesso ao codigo fonte. Ele vai compor a implementação
//		- Se usa @Bean quando não se tem acesso ao codigo fonta da aplicação

// No exemplo, não foi necessário criar uma classe para os beans. Somente com o @Autowired, a aplicação já entendeu e instanciou Gson, mesmo não sendo nativo.