package com.spring.reactive.demo.service;

import com.spring.reactive.demo.model.SuperHero;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactiveSuperHeroService {

    Flux<?> findAll();

    Mono<SuperHero> findById(int id);

    Mono<SuperHero> save(SuperHero superHero);

    Mono<SuperHero> update(int id, SuperHero superHero);

    Mono<Void> delete(int id);
}
