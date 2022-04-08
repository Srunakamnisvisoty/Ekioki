package game.ekivoki.service;

import game.ekivoki.model.GameSession;

import java.util.List;

public interface GameSessionService {

    GameSession findOne(Long id);

    List<GameSession> findAll();

    GameSession create(GameSession gameSession);

    GameSession findBySessionUuid(String sessionUUID);

    void remove();


}
