package com.gmail.fabio91oliveira.reactivemicroservicejava.service;

import com.gmail.fabio91oliveira.reactivemicroservicejava.model.Person;
import com.gmail.fabio91oliveira.reactivemicroservicejava.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Flux<Person> getAll() {
        return this.personRepository.findAll();
    }

    public Mono<Person> save(Person person){
        return this.personRepository.save(person);
    }

    public Mono<Void> deleteAll() {
        return this.personRepository.deleteAll();
    }
}
