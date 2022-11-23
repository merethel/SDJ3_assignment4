package Persistence.Daos.DaoImplementations;

import Persistence.Daos.DaoInterfaces.IAnimalPartDao;
import Shared.Animal;
import Shared.AnimalPart;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

public class AnimalPartDao implements IAnimalPartDao {

    private final SessionFactory sessionFactory;

    public AnimalPartDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public AnimalPart create(AnimalPart animalPart) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        AnimalPart animalPartToReturn = null;


        try {
            transaction = session.beginTransaction();

            // here get object
            int animalPartId = (int) session.save(animalPart);
            animalPartToReturn = session.get(AnimalPart.class, animalPartId);
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

        return animalPartToReturn;
    }

    @Override
    public AnimalPart getById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        AnimalPart animalPartToReturn = null;


        try {
            transaction = session.beginTransaction();

            // here get object
            animalPartToReturn = session.get(AnimalPart.class, id);
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

        return animalPartToReturn;    }
}
