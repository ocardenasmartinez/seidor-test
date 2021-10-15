package cl.seidor.entities.data;

import lombok.*;

import javax.persistence.*;

@Entity(name = "universities")
@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UniversityEntity {



    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "alpha_two_code")
    private String alphaTwoCode;

    @Column
    private String name;

    @Column
    private String country;

}
