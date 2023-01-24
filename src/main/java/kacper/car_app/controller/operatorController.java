package kacper.car_app.controller;

import kacper.car_app.dao.userDao;
import kacper.car_app.dao.zgloszenieDao;
import kacper.car_app.model.Client;
import kacper.car_app.model.Zgloszenie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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


//    Dodanie zgloszenia
//
//
    @GetMapping("/adminPanel/dodaj-zgloszenie")
    public ModelAndView dodajZgloszenieDoBazy(Model m){
        m.addAttribute("zgloszenie", new Zgloszenie());
        return new ModelAndView("adminDodajZgloszenie");
    }

    @PostMapping("/adminPanel/dodaj-zgloszenie")
    public ModelAndView returnZgloszeniePage(@Valid Zgloszenie zgloszenie, BindingResult binding, Model m) {
        if(binding.hasErrors()){
            System.out.println("Błędne dane!");
            return new ModelAndView("adminDodajZgloszenie");
        }

        zgloszeniaDao.save(zgloszenie);
        m.addAttribute("zgloszenia", zgloszeniaDao.findAll());

        return new ModelAndView("adminMainPage");
    }

    @PostMapping("/adminPanel/edytuj-zgloszenie/{id}")
    public ModelAndView edytujZgloszenie(@Valid Zgloszenie zgloszenie,BindingResult binding, @PathVariable Long id, Model m) {
        if(binding.hasErrors()){
            System.out.println("Błędne dane!");
            return new ModelAndView("adminEdytujZgloszenie");
        }
        if(zgloszeniaDao.findById(id) == null) System.out.println("Błąd pobrania danych!");
        else {
                Zgloszenie updatedZgloszenie = zgloszeniaDao.findById(id);

                updatedZgloszenie.setStatus(zgloszenie.getStatus());
                updatedZgloszenie.setOpis(zgloszenie.getOpis());
                updatedZgloszenie.setTyp(zgloszenie.getTyp());
                updatedZgloszenie.setMarka(zgloszenie.getMarka());
                updatedZgloszenie.setModel(zgloszenie.getModel());
                updatedZgloszenie.setTelefon(zgloszenie.getTelefon());
                zgloszeniaDao.save(updatedZgloszenie);

        }
        m.addAttribute("zgloszenia", zgloszeniaDao.findAll());
        return new ModelAndView("adminMainPage");
    }

    @PostMapping("/adminRemove/{id}")
    public ModelAndView removeZgloszenie(@PathVariable Long id, Model m) {
        if(zgloszeniaDao.findById(id)!=null) {
            Zgloszenie n = zgloszeniaDao.findById(id);
            zgloszeniaDao.delete(n);
        }else{
            System.out.println("Brak elementu w bd!");
        }
        m.addAttribute("zgloszenia", zgloszeniaDao.findAll());
        return new ModelAndView("adminMainPage");
    }

    @GetMapping("/adminRemove/{id}")
    public ModelAndView removeZgloszenieGet(@PathVariable Long id, Model m) {
        if(zgloszeniaDao.findById(id)!=null) {
            Zgloszenie n = zgloszeniaDao.findById(id);
            zgloszeniaDao.delete(n);
        }else{
            System.out.println("Brak elementu w bd!");
        }
        m.addAttribute("zgloszenia", zgloszeniaDao.findAll());
        return new ModelAndView("adminMainPage");
    }

    @PostMapping("/adminEdit/{id}")
    public ModelAndView editZgloszenie(@PathVariable Long id, Model m) {
        if(zgloszeniaDao.findById(id)!=null) {
            Zgloszenie n = zgloszeniaDao.findById(id);
            m.addAttribute("zgloszenie", n);
            return new ModelAndView("adminEdytujZgloszenie");
        }else{
            return new ModelAndView("adminMainPage");
        }
    }

    @GetMapping("/adminEdit/{id}")
    public ModelAndView editZgloszenie1(@PathVariable Long id, Model m) {
        if(zgloszeniaDao.findById(id)!=null) {
            Zgloszenie n = zgloszeniaDao.findById(id);
            m.addAttribute("zgloszenie", n);
            return new ModelAndView("adminEdytujZgloszenie");
        }else{
            return new ModelAndView("adminMainPage");
        }
    }



}
