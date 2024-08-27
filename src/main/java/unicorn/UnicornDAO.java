package unicorn;

import app.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class UnicornDAO {

    EntityManagerFactory emf = HibernateConfigUnicorn.getEntityManagerFactoryConfig();
    EntityManager em = emf.createEntityManager();


    public Unicorn save (Unicorn unicorn) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(unicorn);
        em.getTransaction().commit();
        em.close();

        return unicorn;
    }


    public Unicorn update (Unicorn unicorn) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(unicorn);
        em.getTransaction().commit();
        em.close();
        return unicorn;
    }


    public void delete (int id) {

        EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();

    Unicorn unicorn = em.find(Unicorn.class, id);

    if (unicorn != null) {
        em.remove(unicorn);
    }
    em.getTransaction().commit();
    em.close();

    }

    public Unicorn findById (int id) {
        EntityManager em = emf.createEntityManager();
        Unicorn unicorn = em.find(Unicorn.class, id);
        em.close();
        return unicorn;
    }

    public List<Unicorn> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Unicorn> unicorns = em.createQuery("from Unicorn").getResultList();
        em.close();
        return unicorns;
    }



    public void close () {
        emf.close();
    }

}
