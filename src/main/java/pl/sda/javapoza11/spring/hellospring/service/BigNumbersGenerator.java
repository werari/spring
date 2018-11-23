package pl.sda.javapoza11.spring.hellospring.service;

import java.util.Random;

public class BigNumbersGenerator implements RandomGenerator {
    @Override
    public Integer randomInt() {
        Random random= new Random();
        return random.nextInt(500)+1000; //generuje 500 do 1500
    }
}
