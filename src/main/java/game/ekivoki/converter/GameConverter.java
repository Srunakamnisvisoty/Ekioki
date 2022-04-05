package game.ekivoki.converter;

import com.geninc.ekivoki.dto.GameDto;
import com.geninc.ekivoki.model.Game;

public interface GameConverter {

    GameDto convert(Game source);

    Game convert(GameDto source);
}
