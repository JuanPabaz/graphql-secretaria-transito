package secretaria.graphql.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "traffic_ticker")
public class TrafficTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "traffic_ticket_id")
    private Long trafficTicketId;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @Column(name = "date")
    private Date date;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "traffic_agent_id")
    private TrafficAgent trafficAgent;

    @ManyToOne
    @JoinColumn(name = "detection_camera_id")
    private DetectionCamera detectionCamera;

    public TrafficTicket() {
    }

    public TrafficTicket(Long trafficTicketId, Vehicle vehicle, Date date, String description, Double price, TrafficAgent trafficAgent, DetectionCamera detectionCamera) {
        this.trafficTicketId = trafficTicketId;
        this.vehicle = vehicle;
        this.date = date;
        this.description = description;
        this.price = price;
        this.trafficAgent = trafficAgent;
        this.detectionCamera = detectionCamera;
    }

    public Long getTrafficTicketId() {
        return trafficTicketId;
    }

    public void setTrafficTicketId(Long trafficTicketId) {
        this.trafficTicketId = trafficTicketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TrafficAgent getTrafficAgent() {
        return trafficAgent;
    }

    public void setTrafficAgent(TrafficAgent trafficAgent) {
        this.trafficAgent = trafficAgent;
    }

    public DetectionCamera getDetectionCamera() {
        return detectionCamera;
    }

    public void setDetectionCamera(DetectionCamera detectionCamera) {
        this.detectionCamera = detectionCamera;
    }
}
