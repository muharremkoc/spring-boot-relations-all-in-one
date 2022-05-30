package com.spring.threerelationsinone.services;

import com.spring.threerelationsinone.domain.Residential;
import com.spring.threerelationsinone.dtos.request.ResidentialRequestDto;
import com.spring.threerelationsinone.dtos.response.ResidentialResponseDto;

import java.util.List;

public interface ResidentialService {

    Residential saveResidential(ResidentialRequestDto residentialRequestDto);
    void  deleteResidential(String id);
    List<ResidentialResponseDto> getAllResidentials();
}
