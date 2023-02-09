package ro.appointment.dashboard.infrastructure;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ro.appointment.dashboard.domain.Appointment;
import ro.appointment.dashboard.domain.AppointmentRepository;

import java.util.List;

@Repository
@AllArgsConstructor
public class AppointmentRepositoryImpl implements AppointmentRepository {
    private MongoTemplate mongoTemplate;


    @Override
    public void createAppointment(final Appointment appointment) {
        this.mongoTemplate.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return this.mongoTemplate.findAll(Appointment.class);
    }

    @Override
    public Appointment getById(final String appointmentId) {
        return this.mongoTemplate.findById(appointmentId,Appointment.class);
    }

    @Override
    public void removeAppointment(String appointmentId) {
    final Query query = new Query(Criteria.where("_id").is(appointmentId));
    this.mongoTemplate.remove(query,Appointment.class);
    }
}
