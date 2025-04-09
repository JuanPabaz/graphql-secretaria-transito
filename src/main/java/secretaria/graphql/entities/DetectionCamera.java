package secretaria.graphql.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "detection_camera")
public class DetectionCamera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "camera_id")
    private Integer cameraId;

    @Column(name = "location")
    private String location;

    @OneToMany(targetEntity = TrafficTicket.class, fetch = FetchType.LAZY, mappedBy = "detectionCamera")
    private List<TrafficTicket> trafficTickets;

    public DetectionCamera() {
    }

    public DetectionCamera(Integer cameraId, String location, List<TrafficTicket> trafficTickets) {
        this.cameraId = cameraId;
        this.location = location;
        this.trafficTickets = trafficTickets;
    }

    public Integer getCameraId() {
        return cameraId;
    }

    public void setCameraId(Integer cameraId) {
        this.cameraId = cameraId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<TrafficTicket> getTrafficTickets() {
        return trafficTickets;
    }

    public void setTrafficTickets(List<TrafficTicket> trafficTickets) {
        this.trafficTickets = trafficTickets;
    }
}
