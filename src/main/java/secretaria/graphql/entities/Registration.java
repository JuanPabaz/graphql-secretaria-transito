package secretaria.graphql.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private Long registrationId;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "brand")
    private String brand;

    @Column(name = "registration_date")
    private Date registrationDate;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public Registration() {
    }

    public Registration(Long registrationId, String licensePlate, String brand, Date registrationDate, User user) {
        this.registrationId = registrationId;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.registrationDate = registrationDate;
        this.user = user;
    }

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
