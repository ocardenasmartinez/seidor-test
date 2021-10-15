package cl.seidor.controllers;

import cl.seidor.business.CarBusiness;
import cl.seidor.controllers.entities.request.InsertCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarsController {

    @Autowired
    private CarBusiness carBusiness;

    @RequestMapping(value = "/insertcar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertCard(@RequestBody InsertCar insertCar) {
        return new ResponseEntity<>(carBusiness.insertCar(), HttpStatus.OK);
    }

}
