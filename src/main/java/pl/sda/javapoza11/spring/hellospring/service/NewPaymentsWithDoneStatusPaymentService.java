package pl.sda.javapoza11.spring.hellospring.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.sda.javapoza11.spring.hellospring.entity.Payment;
import pl.sda.javapoza11.spring.hellospring.entity.PaymentStatus;
import pl.sda.javapoza11.spring.hellospring.repository.PaymentRepository;

import java.time.Instant;
@Service
@Profile("dev")
public class NewPaymentsWithDoneStatusPaymentService implements PaymentActions {

    private PaymentRepository paymentRepository;

    public NewPaymentsWithDoneStatusPaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment findById(long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public void addPayment(String client, Integer price) {
        Payment payment = new Payment(null, client, price, Instant.now(), PaymentStatus.DONE);
        paymentRepository.save(payment);
    }
}
