package point_v2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // Husk altid at smide hver entitet ind i HibernateConfig-filen!!!
@Table(name = "point") // vores database-tabel navn
@NoArgsConstructor // denne laver en tom constructor så vi slipper for selv at gøre det
@Getter // denne laver getter-metoderne
@ToString // denne laver en toString metode
public class Point {

    @Id // annotation - vi fortæller at det her er Id = primary key
    @GeneratedValue (strategy = GenerationType.IDENTITY) // her fortæller vi at hibernate skal generere Id's, men en bestemt strategi
    @Column(name = "id", unique = true) // id'et skal være unikt (vi har sat det som en constraint)
    private int id;

    @Column (name = "x",  nullable = false) // en kolonne i vores tabel som ikke er primary key, og som ikke må være null
    private int x;
    @Column(name = "y", nullable = false)
    private int y;

//    public Point() { // skal være tomt, da Hibernate kan få brug for en tom entity
//        // NoArgsConstructor kan også gøre det for os.
//    }


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
