package transfer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import transfer.entity.Card;
import transfer.repository.CardRepository;

@Service
@AllArgsConstructor
public class CardService {

    private final CardRepository repository;

    public Flux<Card> getCards(int id){
        return repository.findByOwnerId(id);
    }
}
