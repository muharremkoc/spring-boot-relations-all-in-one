package com.spring.threerelationsinone.dtos.response;

import com.spring.threerelationsinone.enums.Skill;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SkillsResponseDto {

    String skillID;

    Skill skill;

}
