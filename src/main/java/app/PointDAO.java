package app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class PointDAO {

    private static PointDAO instance;

    private static EntityManagerFactory emf;

    public static PointDAO getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PointDAO();
        }
        return instance;

    }


    public void savePointsToDB() {
        // Store 1000 Point objects in the database:
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin(); // vi beder altid om at starte en transaktion i EntityManager
        for (int i = 0; i < 1000; i++) {
            Point p = new Point(i, i);
//            em.find(Point.class, 10); // hvis vi fx vil finde en point med nøglen/id 10.
            em.persist(p); // persist = gem eller opdater
        }
        em.getTransaction().commit(); // en transaktion skal altid committes

    }

}
