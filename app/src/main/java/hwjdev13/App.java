
package hwjdev13;
import hwjdev13.service.Client;
import hwjdev13.service.Ticket;
import hwjdev13.service.TicketCrudService.TicketCrudService;
import hwjdev13.storage.Database;
import hwjdev13.storage.DatabaseInitService;
import hwjdev13.storage.hibernate.HibernateUtil;

import java.util.List;

import hwjdev13.service.ClientCrudService.ClientCrudService;
import hwjdev13.service.Planet;
import hwjdev13.service.PlanetCrudService.PlanetCrudService;
import org.hibernate.Session;


public class App {
    public static void main(String[] args) throws Exception {

        Database database = Database.getInstance();
        new DatabaseInitService().initDb(database);

        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        TicketCrudService ticketCrudService =new TicketCrudService();

        // Створення нового Ticket  client = ''
        Ticket newTicket1 = new Ticket();
            System.out.println("       client = '' " );
        try {
            ticketCrudService.saveTicket(newTicket1);
        }  catch(Exception e){
            System.out.println(e.getMessage());
        }
        ClientCrudService clientCrudService = new ClientCrudService();

        Client client = clientCrudService.findClientById(1L);
        System.out.println("    Found Client: " + client.getName());
        List<Ticket> tickets =client.getTickets();
        System.out.println("       Ticket= " + tickets);

         // Створення нового Ticket
        Ticket newTicket = new Ticket();
        newTicket.setClient(client);
        System.out.println("       planetFrom = '' " );
        try {
            ticketCrudService.saveTicket(newTicket);
        }  catch(Exception e){
            System.out.println(e.getMessage());
        }
        PlanetCrudService planetCrudService = new PlanetCrudService();
        Planet planetfrom = planetCrudService.findPlanetById( "EARTH1");
        newTicket.setPlanetFrom(planetfrom);
        System.out.println("       planetTo = '' " );
        try {
            ticketCrudService.saveTicket(newTicket);
        }  catch(Exception e){
            System.out.println(e.getMessage());
        }
        Planet planetTo= planetCrudService.findPlanetById("VEN");
        newTicket.setPlanetTo(planetTo);
        String created_at = "2025-08-12 13:35:20";
        newTicket.setCreated_at(created_at);
        try {
            ticketCrudService.saveTicket(newTicket);
        }  catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("       newTicket= " + newTicket);

        // Читаємо та виводимо Ticket по id
        Ticket ticket = ticketCrudService.findTicketById(3l);
        System.out.println("    Found Ticket: " + ticket.getClient());
        System.out.println("       Ticket= " + ticket);
        // Оновлюємо  Ticket
        planetTo= planetCrudService.findPlanetById("MARS");
         ticket.setPlanetTo(planetTo);
         String created_at1 = "2025-08-13 15:15:10";
         ticket.setCreated_at(created_at1);
         ticketCrudService.updateTicket(ticket);
        System.out.println("    update Ticket: planetTo" + ticket.getPlanetTo());
        System.out.println("       Ticket= " + ticket);
        // Видаляємо  Ticket
        System.out.println("    delete  Ticket: " + ticket.getId()+" "+ticket.getPlanetTo());
        ticketCrudService.deleteTicket(ticket);
         List<Ticket> tickets1 =session.createQuery(" from Ticket", Ticket.class).list();
        System.out.println("       tickets= "+tickets1);

        session.close();

        HibernateUtil.getInstance().close();

    }
}


