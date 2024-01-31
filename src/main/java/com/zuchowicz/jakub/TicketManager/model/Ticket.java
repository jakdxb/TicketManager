package com.zuchowicz.jakub.TicketManager.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    private String firstName;

    private String lastName;

    private String emailAdress;

    private String departure;

    private String destination;

    private LocalDate date;

    private LocalTime time;

    private String ticketType;

    private String prize;

}
