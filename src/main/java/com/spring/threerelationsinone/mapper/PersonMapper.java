package com.spring.threerelationsinone.mapper;

import com.spring.threerelationsinone.domain.Person;
import com.spring.threerelationsinone.dtos.request.PersonRequestDto;
import com.spring.threerelationsinone.dtos.response.PersonResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface PersonMapper {

   @Mappings({
           @Mapping(target = "firstName",source = "firstName"),
           @Mapping(target = "lastName",source = "lastName"),
           @Mapping(target = "age",source = "age")})
    Person personRequestDtoToPerson(PersonRequestDto personRequestDto);

    @Mappings({
            @Mapping(target = "residentialResponseDto",source = "residential"),
            @Mapping(target = "creditCardResponseDtoList",source = "creditCard")
    })
    PersonResponseDto personToPersonResponse(Person person);


    PersonResponseDto personRequestDTOtoPersonResponseDto(PersonRequestDto personRequestDto);
}
