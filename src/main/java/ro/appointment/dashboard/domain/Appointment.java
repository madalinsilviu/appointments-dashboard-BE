package ro.appointment.dashboard.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Document
public class Appointment {
    @Id
    private String id;
    private LocalDateTime appointmentTime;
    private List<Services> services;
    private String userId;


    public void update(final LocalDateTime newAppointmentTime, final List<Services> newServices, final String newUserId) {
        this.appointmentTime = newAppointmentTime;
        this.services = newServices;
        this.userId = newUserId;
    }
}
