package cl.seidor.business;


import cl.seidor.entities.data.UniversityEntity;
import cl.seidor.entities.external.response.Universities;
import cl.seidor.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class UniversityBusinessImpl implements UniversityBusiness {

    private static final String OK = "OK";
    public static final String NOK = "NOK";
    private String universitiesUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public String insertCar(String universityName) {
        ResponseEntity<Universities[]> universitiesResponse = restTemplate.getForEntity(universitiesUrl, Universities[].class);
        if (Optional.ofNullable(universityRepository.findByName(universityName)).isPresent()) return NOK;
        Arrays.asList(universitiesResponse.getBody()).stream().filter(universityFilter(universityName)).forEach(saveUniversities());
        return OK;
    }

    @Override
    public String setUniversitiesUrl(String universitiesUrl) {
        return this.universitiesUrl = universitiesUrl;
    }

    private Consumer<Universities> saveUniversities() {
        return universities -> {
            universityRepository.save(UniversityEntity.builder()
                    .alphaTwoCode(universities.getAlphaTwoCode())
                    .country(universities.getCountry())
                    .name(universities.getName()).build());
        };
    }

    private Predicate<Universities> universityFilter(String universityName) {
        return university -> university.getName().equals(universityName);
    }

}
