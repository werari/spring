package pl.sda.javapoza11.spring.hellospring.service;

import pl.sda.javapoza11.spring.hellospring.entity.Payment;

public interface PaymentActions {

    Payment findById(long id);

    void addPayment (String client, Integer price);
}
