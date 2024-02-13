package hwjdev13.storage.hibernate;

import hwjdev13.service.Client;
import hwjdev13.service.Planet;
import hwjdev13.service.Ticket;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateUtil {
    private static final HibernateUtil INSTANCE;
    @Getter
    private SessionFactory sessionFactory;
    static {
        INSTANCE = new HibernateUtil();
    }
    private HibernateUtil(){
        sessionFactory= new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }
    public static HibernateUtil getInstance(){
        return INSTANCE;
    }
    public void close(){
        sessionFactory.close();
    }


}
