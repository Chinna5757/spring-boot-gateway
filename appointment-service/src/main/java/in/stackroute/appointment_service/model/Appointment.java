package in.stackroute.appointment_service.model;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "appointments")
public class Appointment {
    @MongoId
    private String appointmentId;
    private String doctorName;
    private String patientName;
    private String bookingDate;
    private String bookingStatus;
}
