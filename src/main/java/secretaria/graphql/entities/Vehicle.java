package secretaria.graphql.entities;

import jakarta.persistence.*;
import secretaria.graphql.enums.VehicleType;

import java.util.List;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Long vehicleId;

    @Column(name = "vehicle_type")
    private VehicleType vehicleType;

    @OneToOne
    @JoinColumn(name = "registration_id")
    private Registration registration;

    @OneToMany(targetEntity = TrafficTicket.class, fetch = FetchType.LAZY, mappedBy = "vehicle")
    private List<TrafficTicket> trafficTickets;

    public Vehicle() {
    }

    public Vehicle(Long vehicleId, VehicleType vehicleType, Registration registration, List<TrafficTicket> trafficTickets) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.registration = registration;
        this.trafficTickets = trafficTickets;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public List<TrafficTicket> getTrafficTickets() {
        return trafficTickets;
    }

    public void setTrafficTickets(List<TrafficTicket> trafficTickets) {
        this.trafficTickets = trafficTickets;
    }
}
