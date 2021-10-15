package cl.seidor.controllers;

import cl.seidor.business.UniversityBusiness;
import cl.seidor.entities.response.UniversityInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UniversityController {

    @Autowired
    private UniversityBusiness universityBusiness;

    @RequestMapping(value = "/insertuniversities", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UniversityInsert> insertUniversities() {
        return new ResponseEntity<>(universityBusiness.insertCar(), HttpStatus.OK);
    }

}
