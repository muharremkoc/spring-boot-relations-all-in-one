package com.spring.threerelationsinone.controller;

import com.spring.threerelationsinone.domain.Person;
import com.spring.threerelationsinone.dtos.request.PersonRequestDto;
import com.spring.threerelationsinone.dtos.response.PersonResponseDto;
import com.spring.threerelationsinone.enums.Gender;
import com.spring.threerelationsinone.enums.MarialStatus;
import com.spring.threerelationsinone.enums.Skill;
import com.spring.threerelationsinone.services.PersonService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Person")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/v1/relations")
public class PersonController {

    final PersonService personService;

    @PostMapping("/person")
    public Person savePerson(@RequestBody PersonRequestDto personRequestDto, @RequestParam Gender gender, @RequestParam MarialStatus marialStatus){
        return personService.savePerson(personRequestDto,gender,marialStatus);
    }

    @GetMapping("/person")
    public List<PersonResponseDto> getAllPersons(){
        return personService.getAllPersons();
    }

    @DeleteMapping("/person/{personID}")
    public void deletePerson(@RequestParam("personID") String personID){
        personService.deletePerson(personID);
    }

    @DeleteMapping("/person")
    public void deleteAllPerson(){
        personService.deleteAllPerson();
    }
}
