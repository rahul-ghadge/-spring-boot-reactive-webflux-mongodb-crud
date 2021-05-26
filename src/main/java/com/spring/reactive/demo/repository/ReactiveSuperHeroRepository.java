package com.spring.reactive.demo.repository;

import com.spring.reactive.demo.model.SuperHero;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ReactiveSuperHeroRepository extends ReactiveCrudRepository<SuperHero, Integer> {
}
