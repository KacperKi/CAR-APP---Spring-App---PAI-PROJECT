package kacper.car_app.controller;

import kacper.car_app.model.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/")
public class businessController {

    @GetMapping("/")
    public ModelAndView showClients(){
        return new ModelAndView("homePage");
    }

}
