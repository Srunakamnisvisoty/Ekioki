package game.ekivoki.service.impl;

import game.ekivoki.exception.EntityNotFoundException;
import game.ekivoki.model.Game;
import game.ekivoki.repository.dao.GameRepository;
import game.ekivoki.repository.dao.impl.GameRepositoryImpl;
import game.ekivoki.service.GameService;

import java.util.List;

public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl() {
        this.gameRepository = new GameRepositoryImpl();
    }

    @Override
    public Game findOne(Long id) {
        return gameRepository.findOne(id).orElseThrow(
                () -> new EntityNotFoundException("Game not found by id: " + id)
        );
    }

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public Game create(Game game) {
        return gameRepository.create(game).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Game findGameBySessionUuid(String uuid) {
        return gameRepository.findGameBySessionUuid(uuid).orElseThrow(
                () -> new EntityNotFoundException("Game not found by UUID: " + uuid)
        );
    }

    @Override
    public void remove(Long id) {
        gameRepository.remove(id);
    }
}
