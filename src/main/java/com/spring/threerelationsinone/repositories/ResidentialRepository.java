package com.spring.threerelationsinone.repositories;

import com.spring.threerelationsinone.domain.Residential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentialRepository extends JpaRepository<Residential,String> {
}
