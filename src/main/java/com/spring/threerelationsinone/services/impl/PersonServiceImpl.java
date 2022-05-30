package com.spring.threerelationsinone.services.impl;

import com.spring.threerelationsinone.domain.Person;
import com.spring.threerelationsinone.domain.Skills;
import com.spring.threerelationsinone.dtos.request.PersonRequestDto;
import com.spring.threerelationsinone.dtos.request.SkillsRequestDto;
import com.spring.threerelationsinone.dtos.response.PersonResponseDto;
import com.spring.threerelationsinone.enums.Gender;
import com.spring.threerelationsinone.enums.MarialStatus;
import com.spring.threerelationsinone.enums.Skill;
import com.spring.threerelationsinone.mapper.CreditCardMapper;
import com.spring.threerelationsinone.mapper.PersonMapper;
import com.spring.threerelationsinone.mapper.ResidentialMapper;
import com.spring.threerelationsinone.mapper.SkillsMapper;
import com.spring.threerelationsinone.repositories.PersonRepository;
import com.spring.threerelationsinone.repositories.SkillsRepository;
import com.spring.threerelationsinone.services.PersonService;
import com.spring.threerelationsinone.services.ResidentialService;
import com.spring.threerelationsinone.services.SkillsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonServiceImpl implements PersonService {

    final PersonRepository personRepository;

    final PersonMapper personMapper;
    final ResidentialMapper residentialMapper;
    final CreditCardMapper creditCardMapper;

    final SkillsRepository skillsRepository;

    final SkillsMapper skillsMapper;
    @Override
    public Person savePerson(PersonRequestDto personRequestDto, Gender gender, MarialStatus marialStatus){
        Person person=personMapper.personRequestDtoToPerson(personRequestDto);
        person.setGender(gender);
        person.setMarialStatus(marialStatus);
        person.setResidential(residentialMapper.residentialRequestDtoToResidential(personRequestDto.getResidentialRequestDto()));
        person.addCreditCard(creditCardMapper.creditCardsToCreditCardRequestDtoList(personRequestDto.getCardRequestDto()));
         List<Skills> skills = skillsRepository.findBySkillIn(personRequestDto.getSkillList());
         skills.stream().forEach(person::addSkill);
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(String id) {
           personRepository.deleteById(id);
    }

    @Override
    public List<PersonResponseDto> getAllPersons() {
        List<PersonResponseDto> personResponseDtos = new ArrayList<>();
        personRepository.findAll().stream().forEach(person -> {
            PersonResponseDto personResponseDto=personMapper.personToPersonResponse(person);
            personResponseDtos.add(personResponseDto);
        });
        return personResponseDtos;
    }

    @Override
    public void deleteAllPerson() {
        personRepository.deleteAll();
    }
}
