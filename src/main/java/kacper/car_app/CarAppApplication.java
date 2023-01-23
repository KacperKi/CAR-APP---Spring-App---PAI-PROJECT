package kacper.car_app;

import kacper.car_app.dao.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import kacper.car_app.model.User;


@SpringBootApplication
public class CarAppApplication {

	@Autowired
	private userDao dao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(CarAppApplication.class, args);
	}

	@PostConstruct
	public void init() {
//		dao.save(new User("Kacper", "Kisielewski","administrator", passwordEncoder.encode("administrator")));
	}

}
