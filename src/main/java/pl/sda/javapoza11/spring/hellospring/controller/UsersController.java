package pl.sda.javapoza11.spring.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sda.javapoza11.spring.hellospring.entity.User;
import pl.sda.javapoza11.spring.hellospring.service.UsersService;

import java.util.List;

@RestController // jak mamy restConttrollera warto dodawać /api
@RequestMapping("/users") //prefix wszystkich metod z mappingiem
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping
    public List<User> users(@RequestParam(value = "age", required = false, defaultValue = "18") Integer age) {
        return usersService.findAll();
    } // @RequestParam pozwala metoda się wykona choć może nie przyjśc parametr wiek i wtedy jest docelowo usatwione 18

    @GetMapping(params = "lastName")
    public List<User> usersByLastName(@RequestParam("lastName") String lastName) {
        return usersService.findByLastName(lastName);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Integer id) {
        return usersService.findById(id);
    }//@Path Variable- pobiera dana z htpp
}
