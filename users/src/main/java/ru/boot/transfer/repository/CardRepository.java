package ru.boot.transfer.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import ru.boot.transfer.entity.Card;

import java.util.UUID;

public interface CardRepository extends ReactiveCrudRepository<Card, UUID> {
    Flux<Card> findByOwnerId(int id);
}
