package unicorn;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "unicorn")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Unicorn {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", unique = true, nullable = false)
    private int id;


    @Column (name = "name", length = 100)
    private String name;

    @Column (name = "age")
    private int age;

    @Column (name = "power_strength")
    private int powerStrength;


    public Unicorn(String name, int age, int powerStrength) {
        this.name = name;
        this.age = age;
        this.powerStrength = powerStrength;
    }
}
