package com.aluracursos.bibliolura.Bibliolura;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class BiblioluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BiblioluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.muestraMenu();
	}
}
