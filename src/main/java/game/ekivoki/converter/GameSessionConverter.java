package game.ekivoki.converter;

import com.geninc.ekivoki.dto.GameSessionDto;
import com.geninc.ekivoki.model.GameSession;

public interface GameSessionConverter {

    GameSessionDto convert(GameSession source);

    GameSession convert(GameSessionDto source);
}
