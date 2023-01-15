package kacper.car_app.dao;
import kacper.car_app.model.User;
import org.springframework.data.repository.CrudRepository;

public interface userDao extends CrudRepository<User, Integer> {
    public User findByLogin(String login);
}