package kacper.car_app.controller;

import kacper.car_app.dao.userDao;
import kacper.car_app.dao.zgloszenieDao;
import kacper.car_app.model.Client;
import kacper.car_app.model.Zgloszenie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@RestController
@Controller
public class operatorController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private userDao dao;
    @Autowired
    private zgloszenieDao zgloszeniaDao;

    @GetMapping("/adminMainPage")
    public ModelAndView returnMainPage(Model m,  Principal principal){
            m.addAttribute("user", dao.findByLogin(principal.getName()));
            m.addAttribute("zgloszenia", zgloszeniaDao.findAll());
            return new ModelAndView("adminMainPage");
    }

    @RequestMapping("/login-error")
    public ModelAndView checkState(Model m){
        m.addAttribute("loginError", true);
        return new ModelAndView("adminLoginPage");
    }

    @GetMapping("/login")
    public ModelAndView checkState1(Model m){
        ModelAndView t = new ModelAndView("adminLoginPage");
        return t;
    }

    @GetMapping("/adminPanel/login")
    public ModelAndView checkState2(Model m){
        ModelAndView t = new ModelAndView("adminLoginPage");
        return t;
    }


}
