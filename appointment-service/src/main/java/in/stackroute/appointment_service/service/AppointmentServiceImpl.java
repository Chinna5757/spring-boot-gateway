package in.stackroute.appointment_service.service;

import in.stackroute.appointment_service.dto.AppointmentDto;
import in.stackroute.appointment_service.exception.AppointmentNotFoundException;
import in.stackroute.appointment_service.model.Appointment;
import in.stackroute.appointment_service.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Override
    public Appointment bookAppointment(Appointment appointment) {
        appointment.setBookingStatus("booked");
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public void cancelAppointment(String appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(
                () -> new AppointmentNotFoundException("Appointment not found")
        );

        appointment.setBookingStatus("cancelled");
        appointmentRepository.save(appointment);
    }
}
