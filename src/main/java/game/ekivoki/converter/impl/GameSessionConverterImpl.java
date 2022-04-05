package game.ekivoki.converter.impl;

import game.ekivoki.converter.GameSessionConverter;
import game.ekivoki.dto.GameSessionDto;
import game.ekivoki.model.GameSession;
import game.ekivoki.util.DateUtils;

public class GameSessionConverterImpl implements GameSessionConverter {

    @Override
    public GameSessionDto convert(GameSession source) {
        if (source == null) {
            return null;
        }
        GameSessionDto target = new GameSessionDto();
        target.setId(source.getId());
        target.setSessionUuid(source.getSessionUuid());
        target.setDateCreation(DateUtils.getDate(source.getDateCreation()));
        return target;
    }

    @Override
    public GameSession convert(GameSessionDto source) {
        if (source == null) {
            return null;
        }
        GameSession target = new GameSession();
        target.setId(source.getId());
        target.setSessionUuid(source.getSessionUuid());
        return target;
    }
}
