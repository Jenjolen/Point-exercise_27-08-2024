package point_v2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointDAOV2Test {


    private static EntityManagerFactory emf;
    private static PointDAOV2 dao;

    @BeforeAll
    static void setUpAll() {
        emf = HibernateConfigV2.getEntityManagerFactoryConfig(true);
        dao = PointDAOV2.getInstance(emf);
        dao.savePointsToDB();
    }

    @Test
    void findNumberOfObjects() {
        //given: Set up the conditions.
        long expected = 1000;

        // when: Perform the action.
        long actual = dao.findNumberOfObjects();

        // then: Verify the outcome:
        assertEquals(expected, actual);
    }
}