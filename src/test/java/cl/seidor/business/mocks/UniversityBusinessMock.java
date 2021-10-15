package cl.seidor.business.mocks;

import cl.seidor.business.UniversityBusiness;

public class UniversityBusinessMock implements UniversityBusiness {

    @Override
    public String insertCar(String universityName) {
        return "OK";
    }

    @Override
    public String setUniversitiesUrl(String universitiesUrl) {
        return "";
    }

}
