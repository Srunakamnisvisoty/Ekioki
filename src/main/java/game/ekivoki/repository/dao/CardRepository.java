package game.ekivoki.repository.dao;

import game.ekivoki.model.Card;
import game.ekivoki.repository.JdbcRepository;

import java.util.Optional;

public interface CardRepository extends JdbcRepository<Card> {

    Optional<Card> findByNumber(int number);

    Optional<Card> update(Card card);

    void remove(Long id);
}
