package cl.seidor.business;


import cl.seidor.entities.external.response.Universities;
import cl.seidor.entities.response.UniversityInsert;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Setter
public class UniversityBusinessImpl implements UniversityBusiness {

    private String universitiesUrl;

    @Autowired
    public RestTemplate restTemplate;

    @Override
    public UniversityInsert insertCar() {
        ResponseEntity<List<Universities>> response = restTemplate.exchange(
                universitiesUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Universities>>(){});
        return UniversityInsert.builder().counter(response.getBody().size()).build();
    }

}
