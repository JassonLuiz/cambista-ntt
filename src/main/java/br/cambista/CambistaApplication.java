package br.cambista;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = "br.cambista")
@SpringBootApplication
public class CambistaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CambistaApplication.class, args);
	}

}
