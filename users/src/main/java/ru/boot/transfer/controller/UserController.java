package ru.boot.transfer.controller;

//import lombok.AllArgsConstructor;
//import lombok.extendsern.slf4j.Slf4j;
//import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.boot.transfer.entity.Card;
import ru.boot.transfer.entity.User;
import ru.boot.transfer.service.UserService;

import java.util.List;

@RestController
//@RequestMapping("/")
//@Slf4j
//@AllArgsConstructor
public class UserController {

    private final UserService service;
    private final CardsFeign feign;

    public UserController(UserService service, CardsFeign feign) {
        this.service = service;
        this.feign = feign;
    }

    @GetMapping("/")
    public Mono<ResponseEntity<List<User>>> getUsers() {
        return service.getUsers().log()
                .collectList()
                .map(users -> new ResponseEntity<>(users, HttpStatus.OK))
                .onErrorResume(error -> Mono.just(new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR)));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<User>> getOneUser(@PathVariable int id) {
//        return null;
        return service.getUserById(id)
                .map(user -> {
                    user.setCardList(feign.findCardsByUserId(id).collectList().block());
                    return new ResponseEntity<>(user, HttpStatus.OK);
                }).onErrorResume(error -> Mono.just(new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR)));
//       return  service.findCardsByUsrId(id).collectList()
//               .map(cards -> new ResponseEntity<>(cards, HttpStatus.OK)).log()
//               .onErrorResume(error -> Mono.just(new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR))).log();
    }
}
