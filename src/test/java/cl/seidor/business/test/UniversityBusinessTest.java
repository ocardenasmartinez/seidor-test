package cl.seidor.business.test;

import cl.seidor.business.UniversityBusiness;
import cl.seidor.business.UniversityBusinessImpl;
import cl.seidor.entities.external.response.Universities;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UniversityBusinessTest {

    public static final String NOTHING = "";
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private UniversityBusiness universityBusiness = new UniversityBusinessImpl();

    @Test
    public void insertCarOK() {
        universityBusiness.setUniversitiesUrl(NOTHING);
        when(restTemplate.getForEntity(any(String.class), any(Class.class))).thenReturn(getUniversities());
        universityBusiness.insertCar(NOTHING);
    }

    private ResponseEntity<Universities[]> getUniversities() {
        Universities[] universitiesList = new Universities[2];
        Universities universities1 = new Universities();
        Universities universities2 = new Universities();
        universitiesList[0] = universities1;
        universitiesList[1] = universities2;
        ResponseEntity<Universities[]> serviceResponse = new ResponseEntity<>(universitiesList, HttpStatus.OK);
        return serviceResponse;
    }

}
