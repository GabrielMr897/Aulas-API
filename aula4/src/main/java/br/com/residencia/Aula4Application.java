package br.com.residencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import br.com.residencia.model.Pagamento;

@SpringBootApplication
public class Aula4Application implements CommandLineRunner {

	@Autowired
	private Pagamento pagamento;

	public static void main(String[] args) {
		SpringApplication.run(Aula4Application.class, args);
	}

	@Override
	public void	run(String... args) throws Exception {

		System.out.println("Total a pagar" + " " + pagamento.calcularProcedimentos(200., 80.));
	}
}
