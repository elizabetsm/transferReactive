package transfer.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import transfer.entity.Card;
import transfer.service.CardService;

import java.util.List;

@AllArgsConstructor
@RestController
public class CardController {

    private final CardService service;

    @GetMapping("cards/{id}")
    public Flux<Card> getCards(@PathVariable int id){
        return service.getCards(id).switchIfEmpty(error -> Mono.error(new Exception("no cards for user")));
    }
}
