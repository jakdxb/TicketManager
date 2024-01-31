package com.zuchowicz.jakub.TicketManager.repository;
import com.zuchowicz.jakub.TicketManager.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
