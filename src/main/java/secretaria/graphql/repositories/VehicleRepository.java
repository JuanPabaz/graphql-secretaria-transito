package secretaria.graphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import secretaria.graphql.entities.Vehicle;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

    @Query("SELECT v FROM Vehicle AS v INNER JOIN Registration as r " +
            "ON v.registration.registrationId = r.registrationId " +
            "WHERE r.user.idUser = :userId")
    List<Vehicle> findVehicleByUser(@Param("userId") Integer userId);
}
