package com.spring.threerelationsinone.services;

import com.spring.threerelationsinone.domain.Person;
import com.spring.threerelationsinone.dtos.request.PersonRequestDto;
import com.spring.threerelationsinone.dtos.response.PersonResponseDto;
import com.spring.threerelationsinone.enums.Gender;
import com.spring.threerelationsinone.enums.MarialStatus;
import com.spring.threerelationsinone.enums.Skill;

import java.util.List;

public interface PersonService {

    Person savePerson(PersonRequestDto personRequestDto, Gender gender, MarialStatus marialStatus);
    void deletePerson(String id);
    List<PersonResponseDto> getAllPersons();

    void deleteAllPerson();

}
