package transfer.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import transfer.entity.Card;

import java.util.UUID;

public interface CardRepository extends ReactiveCrudRepository<Card, UUID> {
}
