package com.spring.threerelationsinone.controller;

import com.spring.threerelationsinone.domain.CreditCard;
import com.spring.threerelationsinone.dtos.request.CreditCardRequestDto;
import com.spring.threerelationsinone.dtos.response.CreditCardResponseDto;
import com.spring.threerelationsinone.dtos.response.ResidentialResponseDto;
import com.spring.threerelationsinone.services.CreditCardService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "CreditCard")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/v1/relations")
public class CreditCardController {

    final CreditCardService creditCardService;

    @PostMapping("/creditCard")
    public CreditCard saveCreditCard(@RequestBody CreditCardRequestDto creditCardRequestDto){
        return creditCardService.saveCreditCard(creditCardRequestDto);
    }

    @GetMapping("/creditCard")
    public List<CreditCardResponseDto> getAllCreditCards(){
        return creditCardService.getAllCreditCards();
    }
    @GetMapping("/creditCard/{personID}")
    public List<CreditCardResponseDto> getAllCreditCardsWithPerson(@RequestParam("personID") String personID){
        return creditCardService.getAllCreditCardsWithPersonID(personID);
    }

    @DeleteMapping("/creditCard/{personID}")
    public void deleteCreditCardsWithPerson(@RequestParam("personID") String personID){
         creditCardService.deleteCreditCardWithPersonID(personID);
    }


}
