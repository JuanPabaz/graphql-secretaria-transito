package secretaria.graphql.dto;

import java.util.Date;

public class TrafficTicketResponseDTO {

    private Long trafficTicketId;
    private Integer userId;
    private Long vehicleId;
    private String licensePlate;
    private Date date;
    private String description;
    private Double price;
    private String trafficAgentName;
    private String cameraLocation;

    public TrafficTicketResponseDTO() {
    }

    public TrafficTicketResponseDTO(Long trafficTicketId, Integer userId, Long vehicleId, String licensePlate, Date date, String description, Double price, String trafficAgentName, String cameraLocation) {
        this.trafficTicketId = trafficTicketId;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.licensePlate = licensePlate;
        this.date = date;
        this.description = description;
        this.price = price;
        this.trafficAgentName = trafficAgentName;
        this.cameraLocation = cameraLocation;
    }

    public Long getTrafficTicketId() {
        return trafficTicketId;
    }

    public void setTrafficTicketId(Long trafficTicketId) {
        this.trafficTicketId = trafficTicketId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
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

    public String getTrafficAgentName() {
        return trafficAgentName;
    }

    public void setTrafficAgentName(String trafficAgentName) {
        this.trafficAgentName = trafficAgentName;
    }

    public String getCameraLocation() {
        return cameraLocation;
    }

    public void setCameraLocation(String cameraLocation) {
        this.cameraLocation = cameraLocation;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
}
