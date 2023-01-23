package kacper.car_app.controller;

import kacper.car_app.model.Zgloszenie;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/adminPanel/")
public class operatorController {


    @GetMapping("/login")
    public ModelAndView checkState(Model m){
        return new ModelAndView("adminLoginPage");
    }






}
