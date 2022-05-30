package com.spring.threerelationsinone.controller;

import com.spring.threerelationsinone.domain.Residential;
import com.spring.threerelationsinone.dtos.request.ResidentialRequestDto;
import com.spring.threerelationsinone.dtos.response.ResidentialResponseDto;
import com.spring.threerelationsinone.services.ResidentialService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Residential")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping(value = "/api/v1/relations")
public class ResidentialController {
    final ResidentialService residentialService;

    @PostMapping("/residential")
    public Residential saveResidential(@RequestBody ResidentialRequestDto residentialRequestDto){
        return residentialService.saveResidential(residentialRequestDto);
    }

    @GetMapping("/residential")
    public List<ResidentialResponseDto> getAllResidentials(){
        return residentialService.getAllResidentials();
    }

    @DeleteMapping("/residential")
    public void deleteResidential(String residentialID){
        residentialService.deleteResidential(residentialID);
    }

}
