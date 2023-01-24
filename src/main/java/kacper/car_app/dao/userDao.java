package kacper.car_app.dao;
import kacper.car_app.model.User;
import kacper.car_app.model.Zgloszenie;
import org.springframework.data.repository.CrudRepository;

public interface userDao extends CrudRepository<User, Integer> {
    public User findByLogin(String login);

    public User findByUserid(Long id);

}