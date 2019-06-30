package com.dev.cartorio;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.dev.cartorio.model.Cartorio;
import com.dev.cartorio.repository.CartorioRepository;

@SpringBootApplication
@ComponentScan(basePackages = { "com.dev.cartorio.controller" })
public class CartorioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartorioApplication.class, args);
	}

	@Bean
	CommandLineRunner init(CartorioRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11).mapToObj(i -> {
				Cartorio c = new Cartorio();
				c.setName("Cartorio " + i);
				return c;
			}).map(v -> repository.save(v)).forEach(System.out::println);
		};

	}
}
