package cl.seidor.entities.data;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Builder
@ToString
@Data
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
