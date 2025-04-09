package secretaria.graphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import secretaria.graphql.entities.TrafficTicket;

import java.util.List;

public interface TrafficTicketRepository extends JpaRepository<TrafficTicket, Long> {

    List<TrafficTicket> findTrafficTicketByVehicleVehicleId(Long vehicleId);

    @Query("SELECT t FROM TrafficTicket AS t INNER JOIN Vehicle AS v " +
            "ON t.vehicle.vehicleId = v.vehicleId " +
            "WHERE v.registration.user.idUser = :userId")
    List<TrafficTicket> findTrafficTicketByUser(@Param("userId") Integer userId);
}
