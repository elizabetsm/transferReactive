package ru.boot.transfer.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;
import ru.boot.transfer.entity.Card;

@Component
@ReactiveFeignClient(
        url = "http://localhost:8080",
        name = "client"
)
public interface CardsFeign {

    @GetMapping("cards/{id}")
    Flux<Card> findCardsByUserId(@PathVariable("id") int id);
}
