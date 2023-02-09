package ro.appointment.dashboard.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


class AppointmentTest {

    @Test
    @DisplayName("GIVEN an appointment, WHEN trying to create a new instance, THEN should not throw an exception")
    void t1() {
        //Given
       final String id = UUID.randomUUID().toString();
       final LocalDateTime appointmentTime = LocalDateTime.of(2022,11,20,10,15,18);
       final List<Services> services = List.of(new Services("HairCut",25));
       final String userId = UUID.randomUUID().toString();

       //When
        final Appointment appointment = new Appointment(
                id,
                appointmentTime,
                services,
                userId
        );

        //Then
        assertEquals(id,appointment.getId());
        assertEquals(appointmentTime,appointment.getAppointmentTime());
        assertEquals(services,appointment.getServices());
        assertEquals(userId,appointment.getUserId());
    }

}