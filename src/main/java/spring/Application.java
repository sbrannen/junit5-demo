
package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import demo.Cat;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	@Primary
	Cat catbert() {
		return new Cat("Catbert");
	}

	@Bean
	Cat garfield() {
		return new Cat("Garfield");
	}

}
