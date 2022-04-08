package game.ekivoki.repository.dao;

import game.ekivoki.model.Game;
import game.ekivoki.model.GameSession;
import game.ekivoki.repository.JdbcRepository;

import java.util.Optional;

public interface GameRepository extends JdbcRepository<Game> {

    Optional<Game> findGameBySessionUuid(String uuid);

    void remove(Long id);
}
