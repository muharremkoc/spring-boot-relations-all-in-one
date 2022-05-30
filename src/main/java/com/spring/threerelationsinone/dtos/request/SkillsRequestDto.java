package com.spring.threerelationsinone.dtos.request;

import com.spring.threerelationsinone.enums.Skill;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SkillsRequestDto {

    Skill skill;
}
