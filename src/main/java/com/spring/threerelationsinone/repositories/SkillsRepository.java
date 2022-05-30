package com.spring.threerelationsinone.repositories;

import com.spring.threerelationsinone.domain.Skills;
import com.spring.threerelationsinone.enums.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;

public interface SkillsRepository extends JpaRepository<Skills,String> {


    Skills findBySkill(Skill skill);

    boolean existsSkillsBySkill(Skill skillName);

    List<Skills> findBySkillIn(List<Skill> skill);

}
