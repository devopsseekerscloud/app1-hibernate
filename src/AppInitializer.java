import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class AppInitializer {
    public static void main(String[] args) {
        AppInitializer app = new AppInitializer();
        //app.saveCustomer();
        //app.findCustomer();
        //app.modifyCustomer();
        //app.deleteCustomer();
        //app.allCustomers();
    }

    private void saveCustomer() {
        Customer c1 = new Customer("2", "Bandara", "Panadura", 45000);
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(c1);
        transaction.commit();
        session.close();
    }

    private void findCustomer() {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Customer customer = session.find(Customer.class, "1");
        System.out.println(customer);
    }

    private void modifyCustomer() {
        Customer c1 = new Customer("1", "Bandara", "Galle", 45000);
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(c1);
        transaction.commit();
        session.close();
    }

    private void deleteCustomer() {

        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.find(Customer.class, "1"));
        transaction.commit();
        session.close();
    }

    private void allCustomers() {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Query query = session.createQuery("FROM Customer");// HQL;
        List list = query.list();
        System.out.println(list);
        session.close();
    }

}
