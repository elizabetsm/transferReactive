package ru.boot.transfer.service;

//import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.boot.transfer.entity.User;
import ru.boot.transfer.repository.UserRepository;

@Service
//@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Flux<User> getUsers(){
        return repository.findAll().log();
    }

    public Mono<User> saveUser(Integer id){
        return repository.findById(id);
    }
}
