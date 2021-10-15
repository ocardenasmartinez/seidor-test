package cl.seidor.configurations;

import cl.seidor.business.CarBusiness;
import cl.seidor.business.CarBusinessTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class CarConfigurationTest {

    @Bean
    public CarBusiness getCarBusiness() {
        return new CarBusinessTest();
    }

}
