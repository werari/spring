package pl.sda.javapoza11.spring.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import pl.sda.javapoza11.spring.hellospring.service.BigNumbersGenerator;
import pl.sda.javapoza11.spring.hellospring.service.RandomGenerator;
import pl.sda.javapoza11.spring.hellospring.service.SmallNumbersGenerator;

import java.util.Random;

@SpringBootApplication
public class HellospringApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellospringApplication.class, args);
    }


    @Bean
    public RandomGenerator smallNumbersGenerator() {
        return new SmallNumbersGenerator();
    }

    @Profile("prod")
    @Primary
    @Bean
    public RandomGenerator myBigNumbersGenerator() {
        return new BigNumbersGenerator();
    }

    @Profile("!prod")
    @Primary // adnotacja mowiaca o 'wyzszosci' tego beana nad pozostalymi - potencjalnie dostepnymi w kontekscie
    @Bean // adnotacja na metodzie mowiaca springowi ze ma ta metode wywolac i jej wynik zapisac w kontekscie
    public RandomGenerator bigNumbersGenerator() {
        return new BigNumbersGenerator();
    }

}
