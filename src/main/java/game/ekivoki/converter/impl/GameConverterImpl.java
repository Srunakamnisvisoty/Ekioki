package game.ekivoki.converter.impl;

import game.ekivoki.converter.GameConverter;
import game.ekivoki.dto.GameDto;
import game.ekivoki.model.Game;

public class GameConverterImpl implements GameConverter {
    @Override
    public GameDto convert(Game source) {
        if (source == null) {
            return null;
        }
        GameDto target = new GameDto();
        target.setId(source.getId());
        target.setSessionId(source.getSessionId());
        target.setCardId(source.getCardId());
        return target;
    }

    @Override
    public Game convert(GameDto source) {
        if (source == null) {
            return null;
        }
        Game target = new Game();
        target.setId(source.getId());
        target.setSessionId(source.getSessionId());
        target.setCardId(source.getCardId());
        return target;
    }
}
