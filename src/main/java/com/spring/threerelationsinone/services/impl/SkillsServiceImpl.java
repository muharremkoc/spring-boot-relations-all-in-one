package com.spring.threerelationsinone.services.impl;

import com.spring.threerelationsinone.domain.Skills;
import com.spring.threerelationsinone.dtos.request.SkillsRequestDto;
import com.spring.threerelationsinone.dtos.response.SkillsResponseDto;
import com.spring.threerelationsinone.enums.Skill;
import com.spring.threerelationsinone.mapper.SkillsMapper;
import com.spring.threerelationsinone.repositories.SkillsRepository;
import com.spring.threerelationsinone.services.SkillsService;
import com.spring.threerelationsinone.services.exception.SkillAlreadyException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SkillsServiceImpl implements SkillsService {

    final SkillsMapper skillsMapper;

    final SkillsRepository skillsRepository;

    @Override
    public Skills saveSkills(Skill skills) {
        SkillsRequestDto skillsRequestDto= SkillsRequestDto.builder().skill(skills).build();
        Skills skills1=skillsMapper.skillsToSkillRequestDto(skillsRequestDto);
        if (skillsRepository.existsSkillsBySkill(skills)){
            return getSkill(skills);
        }
        return skillsRepository.save(skills1);
    }

    @Override
    public Skills getSkill(Skill skill) {
        return skillsRepository.findBySkill(skill);
    }

    @Override
    public List<SkillsResponseDto> getAllSkills() {
        List<SkillsResponseDto> skillsResponseDtos=new ArrayList<>();
        skillsRepository.findAll().stream().forEach(skills -> {

            skillsResponseDtos.add(skillsMapper.skillResponseDtoToSkill(skills));
        });
        return skillsResponseDtos;
    }
}
