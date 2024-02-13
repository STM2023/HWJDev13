package hwjdev13.service.TicketCrudService;

import hwjdev13.service.Ticket;
import hwjdev13.storage.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TicketDao {

    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    // Create
    public void save(Ticket ticket) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.persist(ticket);
            } catch (Exception e) {
                throw new Exception(e);
            }

            tx.commit();

        }
    }

    // Read
    public Ticket findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    // Update
    public void update(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
                session.update(ticket);
            tx.commit();

        }
    }

    // Delete
    public void delete(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
                session.delete(ticket);
            tx.commit();

        }
    }
}

