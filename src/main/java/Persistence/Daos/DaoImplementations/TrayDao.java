package Persistence.Daos.DaoImplementations;

import Persistence.Daos.DaoInterfaces.ITrayDao;
import Shared.AnimalPart;
import Shared.Tray;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

public class TrayDao implements ITrayDao {

    private final SessionFactory sessionFactory;

    public TrayDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Tray create(Tray tray) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Tray trayToReturn = null;


        try {
            transaction = session.beginTransaction();

            // here get object
            int trayId = (int) session.save(tray);
            trayToReturn = session.get(Tray.class, trayId);
            transaction.commit();

        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            Logger.getLogger("con").info("Exception: " + ex.getMessage());
            ex.printStackTrace(System.err);
        } finally {
            session.close();
        }

        return trayToReturn;
    }

    @Override
    public Tray getById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Tray trayToReturn = null;


        try {
            transaction = session.beginTransaction();

            // here get object
            trayToReturn = session.get(Tray.class, id);
            transaction.commit();

        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            Logger.getLogger("con").info("Exception: " + ex.getMessage());
            ex.printStackTrace(System.err);
        } finally {
            session.close();
        }

        return trayToReturn;
    }
}
