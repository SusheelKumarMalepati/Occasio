package com.in.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.in.entity.Event;

@Repository
@EnableJpaRepositories
public interface EventRepository extends JpaRepository<Event, Integer>{

	public Optional<Event> findByEventName(String eventName);

}
