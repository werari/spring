package pl.sda.javapoza11.spring.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.javapoza11.spring.hellospring.service.RandomGenerator;

import java.util.List;

@Controller
public class HelloController {
    //    @Qualifier("bigNumbersGenerator") // mowi springowi jaka ma byc nazwa wstrzykiwanego beana
    @Autowired // mowi springowi zeby w to pole wstrzyknac obiekt (bean)
    private RandomGenerator randomGenerator;

    @Autowired
    private List<RandomGenerator> randomGeneratorList;

    @GetMapping("/hello")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView("hello.html");
        modelAndView.addObject("message", "Wera ma Miszkę");
        return modelAndView;
    }
}
