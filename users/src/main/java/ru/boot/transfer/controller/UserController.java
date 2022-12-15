package ru.boot.transfer.controller;

//import lombok.AllArgsConstructor;
//import lombok.extendsern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.boot.transfer.entity.User;
import ru.boot.transfer.service.UserService;

import java.util.List;

@RestController
//@RequestMapping("/")
//@Slf4j
//@AllArgsConstructor
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public Mono<ResponseEntity<List<User>>> getUsers() {
        return service.getUsers().collectList().map(users -> new ResponseEntity<>(users, HttpStatus.OK))
                .onErrorResume(error -> Mono.just(new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR)));
    }

//    public Mono<ServerResponse> getUsers() {
//        public ResponseEntity<Flux<User>> getUsers() {
//        return service.getUsers()
//                .collectList()
//                .flatMap(users -> {
//                    log.info("sending user List {}", users);
//                    return ServerResponse.ok().bodyValue(users);
//                });
//        return ResponseEntity.status(HttpStatus.OK).body(service.getUsers().cache(Duration.ofMillis(1000L)));
//    }

//    @PostMapping
//    public Mono<User> saveUser(){
//        return service.saveUser(UUID.randomUUID());
//    }
}
