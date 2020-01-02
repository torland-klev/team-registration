package app.repository;

import org.springframework.data.repository.CrudRepository;

import app.model.Player;

public interface PlayerRepository extends CrudRepository<Player, Long> {

}
