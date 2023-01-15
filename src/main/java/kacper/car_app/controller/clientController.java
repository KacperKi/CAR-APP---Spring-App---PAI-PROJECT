package kacper.car_app.controller;

import kacper.car_app.model.Client;
import kacper.car_app.repository.ClientRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/client/")
public class clientController {

    @Autowired
    private ClientRepository clientRepository;

//    @GetMapping("/clients")
//    public List<Client> getAllClient(){
//        return clientRepository.findAll();
//    }

    @GetMapping("/showClients")
    public ModelAndView showClients(){
        ModelAndView client = new ModelAndView("list-clients");
        List<Client> list = clientRepository.findAll();
        client.addObject("client", list);
        return client;
    }




}
