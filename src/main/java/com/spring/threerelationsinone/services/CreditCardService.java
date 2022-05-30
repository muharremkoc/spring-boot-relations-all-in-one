package com.spring.threerelationsinone.services;

import com.spring.threerelationsinone.domain.CreditCard;
import com.spring.threerelationsinone.dtos.request.CreditCardRequestDto;
import com.spring.threerelationsinone.dtos.response.CreditCardResponseDto;

import java.util.List;

public interface CreditCardService {

    CreditCard saveCreditCard(CreditCardRequestDto creditCardRequestDto);

    void deleteCreditCardWithPersonID(String personID);

    List<CreditCardResponseDto> getAllCreditCards();

    List<CreditCardResponseDto> getAllCreditCardsWithPersonID(String personID);

}
