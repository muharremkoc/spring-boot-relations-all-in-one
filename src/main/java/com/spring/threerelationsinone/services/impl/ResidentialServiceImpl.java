package com.spring.threerelationsinone.services.impl;

import com.spring.threerelationsinone.domain.Residential;
import com.spring.threerelationsinone.dtos.request.ResidentialRequestDto;
import com.spring.threerelationsinone.dtos.response.PersonResponseDto;
import com.spring.threerelationsinone.dtos.response.ResidentialResponseDto;
import com.spring.threerelationsinone.mapper.ResidentialMapper;
import com.spring.threerelationsinone.repositories.ResidentialRepository;
import com.spring.threerelationsinone.services.ResidentialService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResidentialServiceImpl implements ResidentialService {

    final ResidentialRepository residentialRepository;
    final ResidentialMapper residentialMapper;

    @Override
    public Residential saveResidential(ResidentialRequestDto residentialRequestDto) {
        Residential residential=residentialMapper.residentialRequestDtoToResidential(residentialRequestDto);

        return residentialRepository.save(residential);
    }

    @Override
    public void deleteResidential(String id) {
        residentialRepository.deleteById(id);
    }

    @Override
    public List<ResidentialResponseDto> getAllResidentials() {
        List<ResidentialResponseDto> residentialResponseDtos = new ArrayList<>();
        residentialRepository.findAll().stream().forEach(residential -> {
            ResidentialResponseDto personResponseDto=residentialMapper.residentialToResidentialResponseDto(residential);
            residentialResponseDtos.add(personResponseDto);
        });
        return residentialResponseDtos;
    }

}
