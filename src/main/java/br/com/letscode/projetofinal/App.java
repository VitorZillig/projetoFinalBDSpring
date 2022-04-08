package br.com.letscode.projetofinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
/*

    @Bean
    public CommandLineRunner demo(PessoaService pessoaService) {
        return (args) -> {

            pessoaService.specification();

        };
    }*/
}