package secretaria.graphql.utils;

import java.util.Date;

public class InvoiceDetail {

    private String name;
    private String idNumber;
    private String vehicleBrandName;
    private String vehicleLicensePlate;
    private String description;
    private Double value;
    private String item;
    private Date date;

    public InvoiceDetail() {
    }

    public InvoiceDetail(String name, String idNumber, String vehicleBrandName, String vehicleLicensePlate, String description, Double value, String item, Date date) {
        this.name = name;
        this.idNumber = idNumber;
        this.vehicleBrandName = vehicleBrandName;
        this.vehicleLicensePlate = vehicleLicensePlate;
        this.description = description;
        this.value = value;
        this.item = item;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getVehicleBrandName() {
        return vehicleBrandName;
    }

    public void setVehicleBrandName(String vehicleBrandName) {
        this.vehicleBrandName = vehicleBrandName;
    }

    public String getVehicleLicensePlate() {
        return vehicleLicensePlate;
    }

    public void setVehicleLicensePlate(String vehicleLicensePlate) {
        this.vehicleLicensePlate = vehicleLicensePlate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
