package point_v2;

import app.HibernateConfig;
import app.Point;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class MainV2 {
    public static void main(String[] args) {
//        HibernateConfig.getEntityManagerFactoryConfig(false); // nu kører Hibernate vores klasser og laver dem til SQL og giver det til PostgreSQL

        // kopieret kode fra Point exercise punkt 10:
        EntityManagerFactory emf = HibernateConfigV2.getEntityManagerFactoryConfig(false);
        EntityManager em = emf.createEntityManager();

//        // Store 1000 Point objects in the database:
//        em.getTransaction().begin(); // vi beder altid om at starte en transaktion i EntityManager
//        for (int i = 0; i < 1000; i++) {
//            Point p = new Point(i, i);
////            em.find(Point.class, 10); // hvis vi fx vil finde en point med nøglen/id 10.
//            em.persist(p); // persist = gem eller opdater
//        }
//        em.getTransaction().commit(); // en transaktion skal altid committes
//
//        // Find the number of Point objects in the database:
//        Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p"); // vi skriver Point som vores entitet ikke som i databasen (point)
//        System.out.println("Total Points: " + q1.getSingleResult());
//
//        // Find the average X value:
//        Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
//        System.out.println("Average X: " + q2.getSingleResult());
//
//        // Retrieve all the Point objects from the database:
//        TypedQuery<Point> query = em.createQuery("SELECT p FROM Point p", Point.class); // TypedQuery = en query som kun må indeholde en Point entitet
//        List<Point> results = query.getResultList();
//        for (Point p : results) {
//            System.out.println(p);
//        }

        // Close the database connection:
        em.close(); // husk altid at lukke både EntityMnager og EntityManagerFactory
        emf.close();
    }




}
