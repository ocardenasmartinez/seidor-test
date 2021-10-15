package cl.seidor.entities.external.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Universities {

    @JsonProperty("alpha_two_code")
    private String alphaTwoCode;
    @JsonProperty("web_pages")
    private List<String> webPages;
    private String name;
    private String country;
    private List<String> domains;
    @JsonProperty("state-province")
    private String stateProvince;

}
