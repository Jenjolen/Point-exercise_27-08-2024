package app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

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
        em.close();

    }

    public void findNumberOfObjects () {
        // Find the number of Point objects in the database:
        EntityManager em = emf.createEntityManager();
        Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p"); // vi skriver Point som vores entitet ikke som i databasen (point)
        System.out.println("Total Points: " + q1.getSingleResult());
        em.close();
    }


public void findX () {
    // Find the average X value:
    EntityManager em = emf.createEntityManager();
    Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
    System.out.println("Average X: " + q2.getSingleResult());
    em.close();
}

public void findAllObjects () {
    // Retrieve all the Point objects from the database:
    EntityManager em = emf.createEntityManager();
    TypedQuery<Point> query = em.createQuery("SELECT p FROM Point p", Point.class); // TypedQuery = en query som kun må indeholde en Point entitet
    List<Point> results = query.getResultList();
    for (Point p : results) {
        System.out.println(p);
    }
    em.close();
}

}
