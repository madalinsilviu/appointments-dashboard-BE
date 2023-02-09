package ro.appointment.dashboard.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Services {
    private String serviceName;
    private int servicePrice;
}
