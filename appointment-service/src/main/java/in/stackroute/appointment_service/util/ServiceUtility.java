package in.stackroute.appointment_service.util;


import in.stackroute.appointment_service.dto.AppointmentDto;
import in.stackroute.appointment_service.model.Appointment;
import org.springframework.stereotype.Component;

@Component
public class ServiceUtility {
    public Appointment toEntity(AppointmentDto dto)
    {
        return Appointment.builder().
                doctorName(dto.doctorName()).
                patientName(dto.patientName()).
                bookingDate(String.valueOf(dto.bookingDate())).
                bookingStatus(dto.bookingStatus()).
                build();
    }

    public AppointmentDto toDto(Appointment appointment)
    {
        return new AppointmentDto(
                appointment.getAppointmentId(),
                appointment.getDoctorName(),
                appointment.getPatientName(),
                appointment.getBookingDate(),
                appointment.getBookingStatus()
        );
    }
}
