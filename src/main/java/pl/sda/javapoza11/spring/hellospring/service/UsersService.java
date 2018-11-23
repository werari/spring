package pl.sda.javapoza11.spring.hellospring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.javapoza11.spring.hellospring.entity.User;
import pl.sda.javapoza11.spring.hellospring.repository.UsersRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//@Profile("!prod)
@Service
public class UsersService {


    private UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    public User findById(long id) {
        return usersRepository.findById(id)
                .orElse(null);
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        usersRepository.findAll()
                .forEach(e -> users.add(e));
        return users;
    }

    public List<User> findByLastName(String lastName) {
        return usersRepository.findByLastName(lastName);
    }

    @PostConstruct //jak sie ten obiekt zinstancjonuje to metoda się wywoła i wykona się
    private void init() {
        usersRepository.save(User.builder().firstName("Wera").lastName("Arim").age(30).build());
        usersRepository.save(User.builder().firstName("Julia").lastName("Nowak").age(15).build());
        usersRepository.save(User.builder().firstName("Jan").lastName("Kowalski").age(35).build());
        usersRepository.save(User.builder().firstName("Artur").lastName("Nowicki").age(33).build());
        usersRepository.save(User.builder().firstName("Daniel").lastName("Nowicki").age(33).build());
    }
}
