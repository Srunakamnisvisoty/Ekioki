package game.ekivoki.converter;

import game.ekivoki.dto.CardDto;
import game.ekivoki.model.Card;

public interface CardConverter {

    CardDto convert(Card source);

    Card convert(CardDto source);
}

