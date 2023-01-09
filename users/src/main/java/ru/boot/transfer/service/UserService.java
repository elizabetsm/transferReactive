package ru.boot.transfer.service;

//import lombok.AllArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.boot.transfer.entity.Card;
import ru.boot.transfer.entity.User;
import ru.boot.transfer.repository.CardRepository;
import ru.boot.transfer.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final CardRepository cardRepository;

    public Flux<User> getUsers(){
        return repository.findAll();
    }

    public Mono<User> saveUser(Integer id){
        return repository.findById(id);
    }

   public Mono<User> getUserById(Integer id) {
        return repository.findById(id);
   }

}
