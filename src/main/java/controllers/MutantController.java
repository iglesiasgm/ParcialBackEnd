package controllers;

import model.DnaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.MutantService;

@RestController
@RequestMapping("/mutant")
public class MutantController {

    @Autowired
    private MutantService mutantService;

    @PostMapping
    public ResponseEntity<String> isMutant(@RequestBody DnaRequest dnaRequest) {
        if (mutantService.isMutant(dnaRequest.getDna().toArray(new String[0]))) {
            return ResponseEntity.ok("Mutant");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Human");
        }
    }
}

