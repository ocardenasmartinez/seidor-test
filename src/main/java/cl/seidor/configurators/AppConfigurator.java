package cl.seidor.configurators;

import cl.seidor.business.UniversityBusiness;
import cl.seidor.business.UniversityBusinessImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class AppConfigurator {

    @Value("${cl.seidor.universities.url}")
    private String universitiesUrl;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(10))
                .setReadTimeout(Duration.ofSeconds(10))
                .build();
    }

    @Bean
    public UniversityBusiness getCarBusiness() {
        UniversityBusinessImpl carBusiness = new UniversityBusinessImpl();
        carBusiness.setUniversitiesUrl(universitiesUrl);
        return carBusiness;
    }

}
