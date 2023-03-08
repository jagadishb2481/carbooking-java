package app.carbooking.model;

import app.carbooking.entity.Location;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AvailableBookingRequest {

    Location location;
    LocalDateTime fromDate;
    LocalDateTime toDate;
}
