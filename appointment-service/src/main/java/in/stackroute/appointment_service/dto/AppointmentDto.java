package in.stackroute.appointment_service.dto;

import jakarta.validation.constraints.NotBlank;

public record AppointmentDto(
        String appointmentId,
        @NotBlank(message = "Appointment must have a doctor name") String doctorName,
        @NotBlank(message = "Appointment must have a patient name") String patientName,
        String bookingDate,
        @NotBlank(message = "Appointment must have a booking status") String bookingStatus
) {
}
