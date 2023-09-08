package in.stackroute.appointment_service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class AppointmentServiceMain {
    public static void main(String[] args) {
        SpringApplication.run(AppointmentServiceMain.class,args);
    }
}
