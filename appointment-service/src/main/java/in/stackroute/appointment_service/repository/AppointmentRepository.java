package in.stackroute.appointment_service.repository;

import in.stackroute.appointment_service.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppointmentRepository extends MongoRepository<Appointment,String> {
}
