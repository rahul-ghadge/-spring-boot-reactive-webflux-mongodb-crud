package com.spring.reactive.demo.service.impl;

import com.spring.reactive.demo.model.SuperHero;
import com.spring.reactive.demo.repository.ReactiveSuperHeroRepository;
import com.spring.reactive.demo.service.ReactiveSuperHeroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@Slf4j
public class ReactiveSuperHeroServiceImpl implements ReactiveSuperHeroService {


    @Autowired
    private ReactiveSuperHeroRepository reactiveSuperHeroRepository;

    @Override
    public Flux<?> findAll() {
        return reactiveSuperHeroRepository.findAll()
                .delayElements(Duration.ofSeconds(1))
                .log();     // log() to print event stream on console. Check console for event logs
    }

    @Override
    public Mono<SuperHero> findById(int id) {
        return reactiveSuperHeroRepository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("** Superhero not found for id :: " + id)))
                .log();     // log() to print event stream on console. Check console for event logs
    }

    @Override
    public Mono<SuperHero> save(SuperHero superHero) {
        return reactiveSuperHeroRepository.save(superHero)
                .log();     // log() to print event stream on console. Check console for event logs
    }

    @Override
    public Mono<SuperHero> update(int id, SuperHero superHero) {
        reactiveSuperHeroRepository.findById(id).switchIfEmpty(Mono.error(new RuntimeException("** Superhero not found for id :: " + id)));
        superHero.setId(id);
        return this.save(superHero);
    }

    @Override
    public Mono<Void> delete(int id) {
        reactiveSuperHeroRepository.findById(id).doOnNext(reactiveSuperHeroRepository::delete);
        return Mono.empty();
    }
}
