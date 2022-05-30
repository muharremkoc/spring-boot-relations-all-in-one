package com.spring.threerelationsinone.mapper;

import com.spring.threerelationsinone.domain.Person;
import com.spring.threerelationsinone.domain.Residential;
import com.spring.threerelationsinone.dtos.request.ResidentialRequestDto;
import com.spring.threerelationsinone.dtos.response.PersonResponseDto;
import com.spring.threerelationsinone.dtos.response.ResidentialResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface ResidentialMapper {

    Residential residentialRequestDtoToResidential(ResidentialRequestDto residentialRequestDto);

    @Mappings({
            @Mapping(target = "residentialID",source = "residentialID"),
            @Mapping(target = "address",source = "address"),
            @Mapping(target = "city",source = "city"),
    })
    ResidentialResponseDto residentialToResidentialResponseDto(Residential residential);
}
