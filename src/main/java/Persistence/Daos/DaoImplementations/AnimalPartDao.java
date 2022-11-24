package Persistence.Daos.DaoImplementations;

import Persistence.Daos.DaoInterfaces.IAnimalPartDao;
import Shared.Dtos.AnimalPartCreationDto;
import Shared.Model.Animal;
import Shared.Model.AnimalPart;
import Shared.Model.Tray;
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
    public AnimalPart create(AnimalPartCreationDto animalPart) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        AnimalPart animalPartToReturn = null;


        try {
            transaction = session.beginTransaction();

            // here get object
            AnimalPart animalPartToSave = new AnimalPart(

            );
            animalPartToSave.setTypeOfPart(animalPart.getTypeOfPart());
            animalPartToSave.setAnimalIComeFrom(session.get(Animal.class, animalPart.getAnimalIComeFromId()));
            animalPartToSave.setTrayIComeFrom(session.get(Tray.class, animalPart.getTrayIComeFromId()));
            animalPartToSave.setWeight(animalPart.getWeight());

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
