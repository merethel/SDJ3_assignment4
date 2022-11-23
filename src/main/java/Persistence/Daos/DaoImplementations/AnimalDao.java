package Persistence.Daos.DaoImplementations;

import Persistence.Daos.DaoInterfaces.IAnimalDao;
import Shared.Animal;
import Shared.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class AnimalDao implements IAnimalDao {

    private final SessionFactory sessionFactory;


    public AnimalDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Animal create(Animal animal) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Animal animalToReturn = null;


        try {
            transaction = session.beginTransaction();

            // here get object
            int animalId = (int) session.save(animal);
            animalToReturn = session.get(Animal.class, animalId);
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

        return animalToReturn;
    }

    @Override
    public Animal getById(int animalId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Animal animalToReturn = null;


        try {
            transaction = session.beginTransaction();

            // here get object
            animalToReturn = session.get(Animal.class, animalId);
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

        return animalToReturn;
    }

    @Override
    public List<Animal> getAllAnimals() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Animal> animalsToReturn = new ArrayList<>();


        try {
            transaction = session.beginTransaction();

            // here get object


            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Animal> criteria = builder.createQuery(Animal.class);
            criteria.from(Animal.class);
            animalsToReturn = session.createQuery(criteria).getResultList();

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

        return animalsToReturn;
    }

    @Override
    public List<Animal> getAnimalsByParameters(Animal animalParameters) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Animal> animalsToReturn = new ArrayList<>();


        try {
            transaction = session.beginTransaction();

            // here get object

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Animal> criteria = builder.createQuery(Animal.class);
            criteria.from(Animal.class);
            List<Animal> animals = session.createQuery(criteria).getResultList();

            if(animalParameters.getOrigin() != null)
            {
                for (Animal animal: animals
                ) {
                    if(animal.getOrigin().equals(animalParameters.getOrigin()))
                        animalsToReturn.add(animal);
                }
            }
            if(animalParameters.getDate() != null)
            {
                for (Animal animal: animals
                ) {
                    if(animal.getDate().equals(animalParameters.getDate()))
                        animalsToReturn.add(animal);
                }
            }

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

        return animalsToReturn;    }
}
