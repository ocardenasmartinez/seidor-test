package cl.seidor.business;

import cl.seidor.entities.response.UniversityInsert;

public class UniversityBusinessTest implements UniversityBusiness {

    @Override
    public UniversityInsert insertCar() {
        return UniversityInsert.builder().counter(1).build();
    }

}
