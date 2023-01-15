package kacper.car_app.repository;

import kacper.car_app.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/*JpaRepository extends PagingAndSortingRepository extends CrudRepository*/
public interface ClientRepository extends JpaRepository<Client, Long> {

}
