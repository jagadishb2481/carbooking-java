package app.carbooking.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CarBookingUtil {

    public static LocalDateTime stringToLocalDateTime(String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
        return dateTime;
    }
}
