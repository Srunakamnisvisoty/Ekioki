package game.ekivoki.converter;

import game.ekivoki.dto.GameSessionDto;
import game.ekivoki.model.GameSession;

public interface GameSessionConverter {

    GameSessionDto convert(GameSession source);

    GameSession convert(GameSessionDto source);
}
