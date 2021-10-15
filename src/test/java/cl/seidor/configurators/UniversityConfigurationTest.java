package cl.seidor.configurators;

import cl.seidor.business.UniversityBusiness;
import cl.seidor.business.mocks.UniversityBusinessMock;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class UniversityConfigurationTest {

    @Bean
    public UniversityBusiness getCarBusiness() {
        return new UniversityBusinessMock();
    }

}
