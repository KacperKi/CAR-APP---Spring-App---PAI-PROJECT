package kacper.car_app.dao;

import kacper.car_app.model.Zgloszenie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface zgloszenieDao extends CrudRepository<Zgloszenie, Integer> {
    public Zgloszenie findById(Long id);
}
