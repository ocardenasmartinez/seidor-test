package cl.seidor.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import cl.seidor.configurations.CarConfigurationTest;
import cl.seidor.controllers.entities.request.InsertCar;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@ContextConfiguration(classes = { CarConfigurationTest.class })
@WebMvcTest(controllers = CarsController.class)
public class CarControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void insertCar() throws Exception {
        this.mvc.perform(post("/insertcar")
                .content(objectMapper.writeValueAsString(getBuild()))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("OK")));

    }

    private InsertCar getBuild() {
        return InsertCar.builder().mark("").model("").age(1).build();
    }


}
