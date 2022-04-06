package game.ekivoki.repository.dao;

import game.ekivoki.repository.JdbcRepository;

public interface CardRepository extends JdbcRepository {

    void remove(Long id);
}
