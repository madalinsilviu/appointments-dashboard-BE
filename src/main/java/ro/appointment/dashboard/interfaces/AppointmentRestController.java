package ro.appointment.dashboard.interfaces;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.appointment.dashboard.application.AppointmentService;
import ro.appointment.dashboard.application.dtos.AppointmentDTO;
import ro.appointment.dashboard.domain.Appointment;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/appointment")
@CrossOrigin
public class AppointmentRestController {
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<Void> create(final @RequestBody AppointmentDTO dto) {
        this.appointmentService.createAppointment(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAll() {
        return ResponseEntity.ok(this.appointmentService.getAllAppointments());
    }

    @PutMapping("/{appointmentId}")
    public ResponseEntity<Void> update(final @PathVariable String appointmentId, final @RequestBody AppointmentDTO dto) {
        this.appointmentService.updateAppointment(appointmentId,dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<Void> delete(final @PathVariable String appointmentId) {
        this.appointmentService.removeAppointment(appointmentId);
        return ResponseEntity.ok().build();
    }
}
