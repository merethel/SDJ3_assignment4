package Persistence.Daos.DaoImplementations;

import Persistence.Daos.DaoInterfaces.IProductDao;
import Shared.Animal;
import Shared.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.persister.entity.Queryable;
import org.jboss.logging.Logger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ProductDao implements IProductDao {

    private final SessionFactory sessionFactory;


    public ProductDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Product create(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Product productToReturn = null;


        try {
            transaction = session.beginTransaction();

            // here get object
            int productId = (int) session.save(product);
            productToReturn = session.get(Product.class, productId);
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

        return productToReturn;
    }

    @Override
    public Product getById(int productId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Product productToReturn = null;


        try {
            transaction = session.beginTransaction();

            // here get object
            productToReturn = session.get(Product.class, productId);
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

        return productToReturn;
    }

    @Override
    public List<Product> getAllProducts() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Product> productsToReturn = null;


        try {
            transaction = session.beginTransaction();

            // here get object
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
            criteria.from(Product.class);
            productsToReturn = session.createQuery(criteria).getResultList();

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

        return productsToReturn;
    }
}
