package pl.sda.javapoza11.spring.hellospring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import pl.sda.javapoza11.spring.hellospring.entity.Payment;
import pl.sda.javapoza11.spring.hellospring.service.PaymentActions;


@RestController
public class PaymentController {
    private PaymentActions paymentActions;

    public PaymentController(PaymentActions paymentActions) {
        this.paymentActions = paymentActions;
    }


    @GetMapping("/payment/{id}")
    public Payment findById(@PathVariable("id") Long id) {
        return paymentActions.findById(id);
    }

    @PostMapping("/payment")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPayment(@RequestParam("client") String client, @RequestParam("price") Integer price) {
        paymentActions.addPayment(client, price);

    }

}

