package app.carbooking.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;

@NoArgsConstructor
@Entity
@Table(name = "Cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String plateNumber;
    @Column(nullable = false)
    private String name;

    private String model;

    private Integer makeYear;
    private String color;
    private String carType;
    @Column(nullable = false)
    private Double pricePerDay;
    @Column(nullable = false)
    private boolean isAvailable;

    private Integer ownerId;
    @Lob
    @Column(name = "image")
    private byte[] image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getMakeYear() {
        return makeYear;
    }

    public void setMakeYear(Integer makeYear) {
        this.makeYear = makeYear;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
// Getters and Setters

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", plateNumber='" + plateNumber + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", makeYear=" + makeYear +
                ", color='" + color + '\'' +
                ", carType='" + carType + '\'' +
                ", pricePerDay=" + pricePerDay +
                ", isAvailable=" + isAvailable +
                ", ownerId=" + ownerId +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
