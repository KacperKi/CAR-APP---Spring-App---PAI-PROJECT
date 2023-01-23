package kacper.car_app.controller;

import kacper.car_app.model.Client;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/")
public class businessController {
    @GetMapping("/")
    public ModelAndView showHomePage(){
        return new ModelAndView("homePage");
    }

    @GetMapping("/galleryPage")
    public ModelAndView showGalleryPage(){
        return new ModelAndView("galleryPage");
    }

    @GetMapping("/faqs")
    public ModelAndView showFAQS(){
        return new ModelAndView("faqs");
    }

    @GetMapping("/services-info")
    public ModelAndView showServices(){
        return new ModelAndView("servicesPageInfo");
    }

    @GetMapping("/about-us/{nameOfWebPage}")
    public ModelAndView showAboutUs(Model m, @PathVariable String nameOfWebPage){
        //String name = request.getParameter("user_name");
        //model.addAttribute("name",name);
        String nameOfPage = "";
        switch(nameOfWebPage){
            case "onas":
                nameOfPage = "Poznaj nas bliżej!";
                break;
            case "kontakt":
                nameOfPage = "Kontakt z nami to przyjemność!!";
                break;
            case "faqs":
                nameOfPage = "Często zadawane pytania?\n Sprawdź niżej!";
                break;
        }
        m.addAttribute("pageName", nameOfPage);
        return new ModelAndView("aboutPage");
    }

}
