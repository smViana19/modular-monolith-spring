package br.com.bot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.bot.app", "br.com.bot.webservices", "br.com.bot.infra", "br.com.bot.core"})
@EnableJpaRepositories(basePackages = "br.com.bot.infra")  // <- aqui
@EntityScan(basePackages = "br.com.bot.infra")  // para suas entidades JPA
public class BotApplication {

  public static void main(String[] args) {
    SpringApplication.run(BotApplication.class, args);
  }

}
