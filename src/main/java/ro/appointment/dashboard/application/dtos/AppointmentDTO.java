package ro.appointment.dashboard.application.dtos;

import lombok.Getter;
import ro.appointment.dashboard.domain.Services;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class AppointmentDTO {
    private String appointmentTime;
    private List<ServiceDTO> services;
    private String userId;
}
