package com.spring.threerelationsinone.dtos.response;

import com.spring.threerelationsinone.enums.Gender;
import com.spring.threerelationsinone.enums.MarialStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonResponseDto {


    String personID;

    String firstName;

    String lastName;

    int age;

    Gender gender;

    MarialStatus marialStatus;

    ResidentialResponseDto residentialResponseDto;


   List<CreditCardResponseDto> creditCardResponseDtoList;


    List<SkillsResponseDto> skillsResponseDto;
}
