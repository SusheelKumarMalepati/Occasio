package com.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.in.entity.RegistrationDetails;

@Repository
@EnableJpaRepositories
public interface RegistrationRepository extends JpaRepository<RegistrationDetails, Integer>{
	
}
