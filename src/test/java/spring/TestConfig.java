
package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import demo.Cat;

@Configuration
public class TestConfig {

	@Primary
	@Bean
	Cat catbert() {
		return new Cat("Catbert");
	}

	@Bean
	Cat garfield() {
		return new Cat("Garfield");
	}

}
