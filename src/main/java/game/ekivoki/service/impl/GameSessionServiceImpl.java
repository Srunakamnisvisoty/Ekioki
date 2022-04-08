package game.ekivoki.service.impl;

import game.ekivoki.exception.EntityNotFoundException;
import game.ekivoki.model.GameSession;
import game.ekivoki.repository.dao.GameSessionRepository;
import game.ekivoki.repository.dao.impl.GameSessionRepositoryImpl;
import game.ekivoki.service.GameSessionService;

import java.util.List;

public class GameSessionServiceImpl implements GameSessionService {

    private final GameSessionRepository gameSessionRepository;

    public GameSessionServiceImpl() {
        this.gameSessionRepository = new GameSessionRepositoryImpl();
    }

    @Override
    public GameSession findOne(Long id) {
        return gameSessionRepository.findOne(id).orElseThrow(
                () -> new EntityNotFoundException("GameSession not found by id: " + id)
        );
    }

    @Override
    public List<GameSession> findAll() {
        return gameSessionRepository.findAll();
    }


    @Override
    public GameSession create(GameSession gameSession) {
        return gameSessionRepository.create(gameSession).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public GameSession findBySessionUuid(String sessionUUID) {
        return gameSessionRepository.findBySessionUuid(sessionUUID).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void remove() {
        gameSessionRepository.remove();
    }
}
