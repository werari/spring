package pl.sda.javapoza11.spring.hellospring.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.javapoza11.spring.hellospring.entity.User;

import java.util.List;

public interface UsersRepository extends CrudRepository <User, Long> {
    List<User> findByLastName(String lastName);
}
