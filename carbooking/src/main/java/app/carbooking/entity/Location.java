package app.carbooking.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
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

}
