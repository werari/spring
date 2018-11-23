package pl.sda.javapoza11.spring.hellospring.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.javapoza11.spring.hellospring.entity.Payment;

import java.util.List;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
        List<Payment> findByClientAndPrice (String client, Integer price);


}