package in.stackroute.appointment_service.controller;

import in.stackroute.appointment_service.dto.AppointmentDto;
import in.stackroute.appointment_service.exception.AppointmentNotFoundException;
import in.stackroute.appointment_service.model.Appointment;
import in.stackroute.appointment_service.service.AppointmentService;
import in.stackroute.appointment_service.util.ServiceUtility;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final ServiceUtility utility;

    @PostMapping("/book")
    public ResponseEntity<AppointmentDto> bookAppointment(@Valid @RequestBody AppointmentDto dto) {
        var appointment = utility.toEntity(dto);
        var savedAppointment = appointmentService.bookAppointment(appointment);
        var savedAppointmentDto = utility.toDto(savedAppointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAppointmentDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        if (appointments.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(appointments);
    }

    @DeleteMapping("/cancel/{appointmentId}")
    public ResponseEntity<Void> cancelAppointment(@PathVariable String appointmentId) {
        try {
            appointmentService.cancelAppointment(appointmentId);
            return ResponseEntity.ok().build();
        } catch (AppointmentNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
