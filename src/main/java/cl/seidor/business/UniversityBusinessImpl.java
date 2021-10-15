package cl.seidor.business;


import cl.seidor.entities.data.UniversityEntity;
import cl.seidor.entities.external.response.Universities;
import cl.seidor.repositories.UniversityRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Setter
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
        ResponseEntity<List<Universities>> response = restTemplate.exchange(
                universitiesUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Universities>>(){});
                if(Optional.ofNullable(universityRepository.findByName(universityName)).isPresent()) return NOK;
                response.getBody().stream()
                .filter(universityFilter(universityName))
                .forEach(saveUniversities());
        return OK;
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
