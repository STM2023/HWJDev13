package hwjdev13.service.TicketCrudService;

import hwjdev13.service.Ticket;
public class TicketCrudService {
    private TicketDao ticketDao = new TicketDao();

    public void saveTicket(Ticket ticket) throws Exception {

        ticketDao.save(ticket);
    }
    public Ticket findTicketById(Long id) {
        return ticketDao.findById(id);
    }

    public void updateTicket(Ticket ticket) {
        ticketDao.update(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        ticketDao.delete(ticket);
    }
}