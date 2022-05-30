package com.spring.threerelationsinone.services;

import com.spring.threerelationsinone.domain.Skills;
import com.spring.threerelationsinone.dtos.response.SkillsResponseDto;
import com.spring.threerelationsinone.enums.Skill;

import java.util.List;

public interface SkillsService {

    Skills saveSkills(Skill skill);

    Skills getSkill(Skill skill);

    List<SkillsResponseDto> getAllSkills();
}
