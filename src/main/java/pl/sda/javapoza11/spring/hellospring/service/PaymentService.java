package pl.sda.javapoza11.spring.hellospring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.sda.javapoza11.spring.hellospring.entity.Payment;

import pl.sda.javapoza11.spring.hellospring.entity.PaymentStatus;
import pl.sda.javapoza11.spring.hellospring.repository.PaymentRepository;

import javax.annotation.PostConstruct;
import java.time.Instant;

@Service
@Profile("!dev")
public class PaymentService implements PaymentActions {

    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }


    public Payment findById(long id) {
        return paymentRepository.findById(id)
                .orElse(null);
    }

    @Override
    public void addPayment(String client, Integer price) {
        Payment payment = new Payment(null, client, price, Instant.now(), PaymentStatus.IN_PROGRESS);
        paymentRepository.save(payment);
    }

    @PostConstruct
    private void init() {
        paymentRepository.save(Payment.builder().client("Jan Nowak").price(500).date(Instant.now().minusSeconds(7 * 24 * 60 * 60)).status(PaymentStatus.DONE).build());
        paymentRepository.save(Payment.builder().client("Anna Nowicka").price(40).date(Instant.now().minusSeconds(1 * 24 * 60 * 60)).status(PaymentStatus.IN_PROGRESS).build());
        paymentRepository.save(Payment.builder().client("Dawid Kowalski").price(50).date(Instant.now().minusSeconds(21 * 24 * 60 * 60)).status(PaymentStatus.CANCELLED).build());

    }
}
