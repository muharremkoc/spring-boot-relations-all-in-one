package com.spring.threerelationsinone.mapper;

import com.spring.threerelationsinone.domain.Skills;
import com.spring.threerelationsinone.dtos.request.SkillsRequestDto;
import com.spring.threerelationsinone.dtos.response.SkillsResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface SkillsMapper {


    @Mappings({
            @Mapping(target = "skill",source = "skill")
    })
    Skills skillsToSkillRequestDto(SkillsRequestDto skillsRequestDto);

    @Mappings({
            @Mapping(target = "skillID",source = "skillID"),
            @Mapping(target = "skill",source = "skill")
    })
    SkillsResponseDto skillResponseDtoToSkill(Skills skills);

    @Mappings({
            @Mapping(target = "skillID",source = "skillID"),
            @Mapping(target = "skill",source = "skill")
    })
    Skills skillsResponseDtoToSkills(SkillsResponseDto skillsResponseDto);

}
