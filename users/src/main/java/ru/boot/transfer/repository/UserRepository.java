package ru.boot.transfer.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ru.boot.transfer.entity.User;

import java.util.UUID;

public interface UserRepository extends ReactiveCrudRepository<User, Integer> {
}
