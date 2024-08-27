package unicorn;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

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


    @Column (name = "name", length = 100, nullable = false)
    private String name;

    @Column (name = "age")
    private int age;

    @Column (name = "power_strength")
    @Min(1)
    @Max(100)
    private int powerStrength;


    public Unicorn(String name, int age, int powerStrength) {
        this.name = name;
        this.age = age;
        this.powerStrength = powerStrength;
    }
}
