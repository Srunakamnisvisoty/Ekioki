package game.ekivoki.service;

import game.ekivoki.model.Card;

import java.util.List;

public interface CardService {

    Card findOne(Long id);

    List<Card> findAll();

    Card save(Card card);

    Card findByNumber(int number);

    void remove(Long id);
}
