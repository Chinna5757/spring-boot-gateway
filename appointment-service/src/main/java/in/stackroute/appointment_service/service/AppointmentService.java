package in.stackroute.appointment_service.service;

import in.stackroute.appointment_service.model.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment bookAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
    void cancelAppointment(String appointmentId);
}