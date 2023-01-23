package kacper.car_app.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class carErrorController implements ErrorController {

    @RequestMapping(value = "/error")
    public ModelAndView errors(){
        return new ModelAndView("error-page");
    }

    @RequestMapping(value = "/error-page")
    public ModelAndView errorsPages(){
        return new ModelAndView("error-page");
    }
}
