package game.ekivoki.converter;

import com.geninc.ekivoki.dto.CardDto;
import com.geninc.ekivoki.model.Card;

public interface CardConverter {

    CardDto convert(Card source);

    Card convert(CardDto source);
}

