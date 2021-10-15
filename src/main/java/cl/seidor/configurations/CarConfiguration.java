package cl.seidor.configurations;

import cl.seidor.business.CarBusiness;
import cl.seidor.business.CardBusinessImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfiguration {

    @Bean
    public CarBusiness getCarBusiness() {
        return new CardBusinessImpl();
    }

}
