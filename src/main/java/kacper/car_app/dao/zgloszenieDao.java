package kacper.car_app.dao;

import kacper.car_app.model.Zgloszenie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface zgloszenieDao extends CrudRepository<Zgloszenie, Integer> {
    public Zgloszenie findById(Long id);
    public List<Zgloszenie> findByTelefon(String telefon);

    public List<Zgloszenie> findByMarka(String marka);


}
