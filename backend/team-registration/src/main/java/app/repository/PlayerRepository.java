package app.repository;

import org.springframework.data.repository.CrudRepository;

import app.model.Player;

public interface UserRepository extends CrudRepository<User, Integer> {

}
