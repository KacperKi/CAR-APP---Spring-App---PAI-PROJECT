package kacper.car_app.dao;

import kacper.car_app.model.Zgloszenie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface zgloszenieDao extends JpaRepository<Zgloszenie, Integer> {
    public Zgloszenie findById(Long id);
}
