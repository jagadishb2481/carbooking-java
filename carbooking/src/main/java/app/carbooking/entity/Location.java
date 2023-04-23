package app.carbooking.entity;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Address is mandatory")
    private String address;

    private String city;
    private String state;
    private String country;
    private String zipcode;

    // getters and setters

    public Location(Integer id, String name, String address, String city, String state, String country, String zipcode) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
    }
}
