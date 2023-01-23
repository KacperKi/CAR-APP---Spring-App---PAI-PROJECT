package kacper.car_app.controller;

import kacper.car_app.dao.zgloszenieDao;
import kacper.car_app.model.Zgloszenie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import javax.validation.Valid;


@RestController
public class serviceController {

    @Autowired
    private zgloszenieDao dao;

    @GetMapping("/check-state")
    public ModelAndView checkState(Model m){
        Zgloszenie newZgloszenie = new Zgloszenie();
        newZgloszenie.setStatus("Wprowadź ID uzyskanego zgłoszenia poniżej.");
        m.addAttribute("zgloszenie", newZgloszenie);
        return new ModelAndView("checkState");
    }

    @PostMapping("/check-state")
    public ModelAndView returnZgloszeniePage(@Valid Zgloszenie zgloszenie, BindingResult binding, Model m) {
        System.out.println("zgloszenie id: " + zgloszenie.getId());
        if(dao.findById(zgloszenie.getId())!= null){
                Zgloszenie tmp = dao.findById(zgloszenie.getId());
                m.addAttribute("zgloszenie",tmp);
        }
        else {
            Zgloszenie newZgloszenie = new Zgloszenie();
            newZgloszenie.setStatus("Serwis nie podjął prac lub nie zarejestrowano zgłoszenia o podanym ID!");
            m.addAttribute("zgloszenie",newZgloszenie);
        }
        return new ModelAndView("checkState");
    }


}
