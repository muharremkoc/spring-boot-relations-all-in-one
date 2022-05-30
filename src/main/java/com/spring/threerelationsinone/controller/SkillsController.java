package com.spring.threerelationsinone.controller;

import com.spring.threerelationsinone.domain.Skills;
import com.spring.threerelationsinone.dtos.response.SkillsResponseDto;
import com.spring.threerelationsinone.enums.Skill;
import com.spring.threerelationsinone.services.SkillsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Skills")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/v1/relations")
public class SkillsController {

    final SkillsService skillsService;

/*   @PostMapping("/skill")
    public Skills saveSkills(@RequestParam Skill skill){
        return skillsService.saveSkills(skill);
    }*/

    @GetMapping("/skill")
    public List<SkillsResponseDto> getAllSkills(){
        return skillsService.getAllSkills();
    }
}
