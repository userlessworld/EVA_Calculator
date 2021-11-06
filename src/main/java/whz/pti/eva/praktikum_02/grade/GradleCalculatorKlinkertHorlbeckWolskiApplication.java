package whz.pti.eva.praktikum_02.grade;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class GradleCalculatorKlinkertHorlbeckWolskiApplication {


	
	public static void main(String[] args) {
		SpringApplication.run(GradleCalculatorKlinkertHorlbeckWolskiApplication.class, args);
	
	}
	
	@Bean
	CommandLineRunner init() {
		return (evt)-> System.out.println("test");
	}

}
