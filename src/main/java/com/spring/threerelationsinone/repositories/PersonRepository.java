package com.spring.threerelationsinone.repositories;

import com.spring.threerelationsinone.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,String>{


}
