package game.ekivoki.converter;

import game.ekivoki.dto.GameDto;
import game.ekivoki.model.Game;

public interface GameConverter {

    GameDto convert(Game source);

    Game convert(GameDto source);
}
