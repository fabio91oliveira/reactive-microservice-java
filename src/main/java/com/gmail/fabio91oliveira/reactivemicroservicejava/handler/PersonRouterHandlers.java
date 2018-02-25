package com.gmail.fabio91oliveira.reactivemicroservicejava.handler;

import com.gmail.fabio91oliveira.reactivemicroservicejava.model.Person;
import com.gmail.fabio91oliveira.reactivemicroservicejava.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class PersonRouterHandlers {

    @Autowired
    private PersonService personService;

    public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        return ServerResponse
                .ok().body(personService.getAll(), Person.class)
                .doOnError(throwable -> new IllegalStateException("Error"));
    }

    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Person.class)
                .flatMap(person -> this.personService.save(person))
                .flatMap(person -> ServerResponse.created(URI.create("/post/" + person.getId())).build()
                .doOnError(throwable -> new IllegalStateException("Error")));
    }

}
