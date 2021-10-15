package cl.seidor.business.test;

import cl.seidor.business.UniversityBusiness;
import cl.seidor.business.UniversityBusinessImpl;
import cl.seidor.entities.data.UniversityEntity;
import cl.seidor.entities.external.response.Universities;
import cl.seidor.repositories.UniversityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
public class UniversityBusinessTest {

    public static final String NOTHING = "";
    public static final String US = "US";
    public static final String UNITED_STATES = "United States";
    public static final String FLORIDA_POLYTECHNIC_UNIVERSITY = "Florida Polytechnic University";
    public static final String OK = "OK";
    @Mock
    private RestTemplate restTemplate;

    @Mock
    private UniversityRepository universityRepository;

    @InjectMocks
    private UniversityBusiness universityBusiness = new UniversityBusinessImpl();

    @Test
    public void insertCarOK() {
        universityBusiness.setUniversitiesUrl(NOTHING);
        when(restTemplate.getForEntity(any(String.class), any(Class.class))).thenReturn(getUniversities());
        when(universityRepository.findByName(any(String.class))).thenReturn(null);
        assertEquals(universityBusiness.insertCar(FLORIDA_POLYTECHNIC_UNIVERSITY), OK);
    }

    private UniversityEntity createUniversityEntity() {
        return UniversityEntity.builder().alphaTwoCode(US).country(UNITED_STATES).name(FLORIDA_POLYTECHNIC_UNIVERSITY).build();
    }

    private ResponseEntity<Universities[]> getUniversities() {
        Universities[] universitiesList = new Universities[1];
        Universities universities = new Universities();
        universities.setAlphaTwoCode(US);
        universities.setCountry(UNITED_STATES);
        universities.setName(FLORIDA_POLYTECHNIC_UNIVERSITY);
        universitiesList[0] = universities;
        ResponseEntity<Universities[]> serviceResponse = new ResponseEntity<>(universitiesList, HttpStatus.OK);
        return serviceResponse;
    }

}
