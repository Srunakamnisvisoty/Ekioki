package game.ekivoki.repository.dao;

import game.ekivoki.model.GameSession;
import game.ekivoki.repository.JdbcRepository;

import java.util.Date;
import java.util.Optional;

public interface GameSessionRepository extends JdbcRepository<GameSession> {

    Optional<GameSession> findBySessionUUID(String sessionUUID);

    void remove();
}
