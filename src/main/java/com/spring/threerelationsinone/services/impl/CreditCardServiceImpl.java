package com.spring.threerelationsinone.services.impl;

import com.spring.threerelationsinone.domain.CreditCard;
import com.spring.threerelationsinone.domain.Person;
import com.spring.threerelationsinone.dtos.request.CreditCardRequestDto;
import com.spring.threerelationsinone.dtos.response.CreditCardResponseDto;
import com.spring.threerelationsinone.dtos.response.ResidentialResponseDto;
import com.spring.threerelationsinone.mapper.CreditCardMapper;
import com.spring.threerelationsinone.repositories.CreditCardRepository;
import com.spring.threerelationsinone.repositories.PersonRepository;
import com.spring.threerelationsinone.services.CreditCardService;
import com.spring.threerelationsinone.services.PersonService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreditCardServiceImpl implements CreditCardService {

    final CreditCardRepository creditCardRepository;

    final PersonRepository personRepository;

    final CreditCardMapper creditCardMapper;

    @Override
    public CreditCard saveCreditCard(CreditCardRequestDto creditCardRequestDto) {
        CreditCard creditCard=creditCardMapper.creditCardToCreditCardRequestDto(creditCardRequestDto);

        return creditCardRepository.save(creditCard);
    }

    @Override
    public void deleteCreditCardWithPersonID(String personID) {
        Person person=personRepository.findById(personID).orElseThrow();

        creditCardRepository.findAllByPerson(person).stream().forEach(creditCard -> {
            person.removeCreditCard(creditCard);
            creditCardRepository.delete(creditCard);
        });

    }

    @Override
    public List<CreditCardResponseDto> getAllCreditCards() {
        List<CreditCardResponseDto> creditCardResponseDtos = new ArrayList<>();
        creditCardRepository.findAll().stream().forEach(creditCard -> {
            CreditCardResponseDto creditCardResponseDto=creditCardMapper.creditCardResponseDtoToCreditCard(creditCard);
            creditCardResponseDtos.add(creditCardResponseDto);
        });
        return creditCardResponseDtos;
    }

    @Override
    public List<CreditCardResponseDto> getAllCreditCardsWithPersonID(String personID) {
        List<CreditCardResponseDto> creditCardResponseDtos = new ArrayList<>();
        Person person=personRepository.findById(personID).orElseThrow();

       creditCardRepository.findAllByPerson(person).stream().forEach(creditCard -> {
            CreditCardResponseDto creditCardResponseDto=creditCardMapper.creditCardResponseDtoToCreditCard(creditCard);
            creditCardResponseDtos.add(creditCardResponseDto);
        });

        return creditCardResponseDtos;
    }
}
