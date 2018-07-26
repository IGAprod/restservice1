package com.restservice.controller;


import com.restservice.exception.ResourceNotFoundException;
import com.restservice.model.Person;
import com.restservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Optional;


@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;


    //@RequestMapping(value = "/input", method = RequestMethod.POST)
  // public ResponseEntity<?> acceptInput(@Valid @RequestBody Data data ) {
    //   dataRepository.save(data);
    //    return new ResponseEntity<>(HttpStatus.OK);
  //  }


    @GetMapping("/persons")
   //@RequestMapping(value = "/persons", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
    public Page<Person> getPerson(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    @GetMapping("/persons/{personsId}")
    public Optional<Person> getPerson(@PathVariable Long personsId) {
        return personRepository.findById(personsId);
    }

    @PostMapping("/persons")
    //@RequestMapping(value ="/persons", method = RequestMethod.POST,produces = { "application/json", "application/xml" })
    public Person createPerson(@Valid @RequestBody Person persons) {
        return personRepository.save(persons);

    }

    @PutMapping("/persons/{personId}")
    //@RequestMapping(value = "/persons/{personId}", method = RequestMethod.PUT,produces = { "application/json", "application/xml" })
    public Person updatePerson(@PathVariable Long personId,
                                   @Valid @RequestBody Person personRequest) {
        return personRepository.findById(personId)
                .map(question -> {
                    question.setFamiliya(personRequest.getFamiliya());
                    question.setImya(personRequest.getImya());
                    question.setReputation(personRequest.getReputation());
                    question.setBorn(personRequest.getBorn());
                    return personRepository.save(question);
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + personId));
    }


    @DeleteMapping("/persons/{personId}")
    //@RequestMapping(value ="/persons/{personId}", method = RequestMethod.DELETE,produces = { "application/json", "application/xml" })
    public ResponseEntity<?> deletePerson(@PathVariable Long personId) {
        return personRepository.findById(personId)
                .map(question -> {
                    personRepository.delete(question);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + personId));
    }
}
