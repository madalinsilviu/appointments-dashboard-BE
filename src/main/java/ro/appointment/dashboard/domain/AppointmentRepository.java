package ro.appointment.dashboard.domain;

import java.util.List;

public interface AppointmentRepository {
    void createAppointment(final Appointment appointment);
    List<Appointment> getAllAppointments();

    Appointment getById(final String appointmentId);
    void removeAppointment(final String appointmentId);
}
