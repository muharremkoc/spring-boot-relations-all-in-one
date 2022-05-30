package com.spring.threerelationsinone;

import com.spring.threerelationsinone.enums.Skill;
import com.spring.threerelationsinone.services.SkillsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootThreeRelationsInOneProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootThreeRelationsInOneProjectApplication.class, args);
    }


    @Bean
    CommandLineRunner run(SkillsService skillsService) {
        return args -> {
            skillsService.saveSkills(Skill.SWIMMER);
            skillsService.saveSkills(Skill.DICTION);
            skillsService.saveSkills(Skill.FAST_LEARN);
            skillsService.saveSkills(Skill.SIGN_LANGUAGE);


        };
    }

}
