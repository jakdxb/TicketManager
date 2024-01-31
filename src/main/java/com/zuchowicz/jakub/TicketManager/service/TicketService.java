package com.zuchowicz.jakub.TicketManager.service;
import com.zuchowicz.jakub.TicketManager.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.zuchowicz.jakub.TicketManager.repository.TicketRepository;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    @Autowired
    public TicketService(TicketRepository ticketRepository) {this.ticketRepository = ticketRepository; }

    public Ticket findTicketById(Long ticketId) {return ticketRepository.findById(ticketId).orElse(null); }
    public List<Ticket> getTickets() {
        return ticketRepository.findAll();
    }
    public Ticket addTicket(Ticket newTicket) {
        if (newTicket == null) {
            throw new IllegalArgumentException("nowy bilet nie moze byc null");
        }
        return ticketRepository.save(newTicket);
    }

    public void deleteTicket(Long ticketId) {
        if(!ticketRepository.existsById(ticketId)) {
            throw new IllegalArgumentException("bilet o podanym id nie istnieje");
        }
        ticketRepository.deleteById(ticketId);
    }

    public Ticket updateTicket(Ticket ticket){
        Ticket existingTicket = ticketRepository.findById(ticket.getTicketId()).orElse(null);
        existingTicket.setFirstName(ticket.getFirstName());
        existingTicket.setLastName(ticket.getLastName());
        existingTicket.setEmailAdress(ticket.getEmailAdress());
        existingTicket.setDeparture(ticket.getDeparture());
        existingTicket.setDestination(ticket.getDestination());
        existingTicket.setDate(ticket.getDate());
        existingTicket.setTime(ticket.getTime());
        existingTicket.setTicketType(ticket.getTicketType());
        existingTicket.setPrize(ticket.getPrize());
        return ticketRepository.save(existingTicket);
    }
}
