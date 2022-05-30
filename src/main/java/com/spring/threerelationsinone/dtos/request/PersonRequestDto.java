package com.spring.threerelationsinone.dtos.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.threerelationsinone.enums.Gender;
import com.spring.threerelationsinone.enums.MarialStatus;
import com.spring.threerelationsinone.enums.Skill;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonRequestDto {

    String firstName;

    String lastName;

    int age;

    ResidentialRequestDto residentialRequestDto;

    List<CreditCardRequestDto> cardRequestDto;

    List<Skill> skillList;

}
