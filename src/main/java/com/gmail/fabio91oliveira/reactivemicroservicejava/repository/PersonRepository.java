package com.gmail.fabio91oliveira.reactivemicroservicejava.repository;

import com.gmail.fabio91oliveira.reactivemicroservicejava.model.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends ReactiveMongoRepository<Person, String> {
}
