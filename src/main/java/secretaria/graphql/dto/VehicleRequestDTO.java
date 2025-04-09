package secretaria.graphql.dto;

import secretaria.graphql.enums.VehicleType;

import java.util.Date;

public class VehicleRequestDTO {

    private String licensePlate;

    private String brand;

    private Date registrationDate;

    private VehicleType vehicleType;

    private Integer userId;

    public VehicleRequestDTO() {
    }

    public VehicleRequestDTO(String licensePlate, String brand, Date registrationDate, VehicleType vehicleType, Integer userId) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.registrationDate = registrationDate;
        this.vehicleType = vehicleType;
        this.userId = userId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
