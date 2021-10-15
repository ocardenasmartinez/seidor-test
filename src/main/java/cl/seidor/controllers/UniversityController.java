package cl.seidor.controllers;

import cl.seidor.business.UniversityBusiness;
import cl.seidor.entities.request.UniversityInsertRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UniversityController {

    @Autowired
    private UniversityBusiness universityBusiness;

    @RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> insertUniversities(@RequestBody UniversityInsertRequest request) {
        return new ResponseEntity<>(universityBusiness.insertCar(request.getName()), HttpStatus.OK);
    }

}
