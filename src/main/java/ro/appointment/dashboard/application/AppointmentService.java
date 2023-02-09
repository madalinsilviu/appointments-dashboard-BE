package ro.appointment.dashboard.application;


import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import ro.appointment.dashboard.application.dtos.AppointmentDTO;
import ro.appointment.dashboard.application.dtos.ServiceDTO;
import ro.appointment.dashboard.domain.Appointment;
import ro.appointment.dashboard.domain.AppointmentRepository;
import ro.appointment.dashboard.domain.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppointmentService {
    private AppointmentRepository appointmentRepository;

    public void createAppointment(final AppointmentDTO appointmentDTO) {
    final Appointment appointment = new Appointment(
            UUID.randomUUID().toString(),
            LocalDateTime.parse(appointmentDTO.getAppointmentTime()),
            mapServicesDTOtoDomain(appointmentDTO.getServices()),
            appointmentDTO.getUserId()
    );
    this.appointmentRepository.createAppointment(appointment);

        }

    private List<Services> mapServicesDTOtoDomain(final List<ServiceDTO> servicesDTO) {
        return servicesDTO.stream().map(dto -> new Services(dto.getServiceName(), dto.getServicePrice())).toList();
    }

    public List<Appointment> getAllAppointments() {
        return this.appointmentRepository.getAllAppointments();
    }

    public void updateAppointment(final String appointmentId, final AppointmentDTO appointmentDTO) {
        final Appointment appointmentToUpdate = this.appointmentRepository.getById(appointmentId);
        appointmentToUpdate.update(
                LocalDateTime.parse(appointmentDTO.getAppointmentTime()),
                mapServicesDTOtoDomain(appointmentDTO.getServices()),
                appointmentDTO.getUserId()
        );
        this.appointmentRepository.createAppointment(appointmentToUpdate);
    }

    public void removeAppointment(final String appointmentId) {
        this.appointmentRepository.removeAppointment(appointmentId);
    }

}
