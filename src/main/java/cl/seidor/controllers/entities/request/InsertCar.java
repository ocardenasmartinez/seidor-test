package cl.seidor.controllers.entities.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InsertCar {

    private String mark;
    private String model;
    private Integer age;

}
