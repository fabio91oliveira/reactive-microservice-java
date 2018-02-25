package com.gmail.fabio91oliveira.reactivemicroservicejava.config;

import com.gmail.fabio91oliveira.reactivemicroservicejava.base.Constants;
import com.gmail.fabio91oliveira.reactivemicroservicejava.handler.PersonRouterHandlers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
public class PersonRouterConfig {

    @Bean
    RouterFunction<?> routerFunction(PersonRouterHandlers personRouterHandlers) {
        return RouterFunctions
                .route(RequestPredicates.GET(Constants.API_PERSON_GET_ALL), personRouterHandlers::getAll)
                .andRoute(RequestPredicates.POST(Constants.API_PERSON), personRouterHandlers::save);
    }
}
