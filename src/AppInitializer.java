import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppInitializer {
    public static void main(String[] args) {
        AppInitializer app = new AppInitializer();
        //app.saveCustomer();
        //app.findCustomer();
        //app.modifyCustomer();
        app.deleteCustomer();
    }

    private void saveCustomer() {
        Customer c1 = new Customer("1", "Nimal", "Colombo", 25000);
        Configuration configuration =
                new Configuration().configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Customer.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(c1);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    private void findCustomer() {
        Configuration configuration =
                new Configuration().configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Customer.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Customer customer = session.find(Customer.class, "1");
        System.out.println(customer);
    }

    private void modifyCustomer() {
        Customer c1 = new Customer("1", "Bandara", "Galle", 45000);
        Configuration configuration =
                new Configuration().configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Customer.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(c1);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    private void deleteCustomer() {
        Configuration configuration =
                new Configuration().configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Customer.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.find(Customer.class,"1"));
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    private void allCustomers() {
    }

}
