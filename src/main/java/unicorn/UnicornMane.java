package unicorn;

import app.HibernateConfig;

public class UnicornMane {

    public static void main(String[] args) {
//        HibernateConfigUnicorn.getEntityManagerFactoryConfig();

    UnicornDAO unicornDAO = new UnicornDAO();


    Unicorn newUnicorn = new Unicorn("Rainbow", 99, 85);
    Unicorn createdUnicorn = unicornDAO.save(newUnicorn);

    // Update
    createdUnicorn.setName("Rainbow&tie");
    unicornDAO.update(createdUnicorn);

//
        // Read
        Unicorn foundUnicorn = unicornDAO.findById(createdUnicorn.getId());
        System.out.println("Found Unicorn: " + foundUnicorn.getName());

        // Update
        foundUnicorn.setAge(505);
        Unicorn updatedUnicorn = unicornDAO.update(foundUnicorn);
        System.out.println("Updated Unicorn Age: " + updatedUnicorn.getAge());

        // Delete
//        unicornDAO.delete(createdUnicorn.getId());



        unicornDAO.close();




    }

}
