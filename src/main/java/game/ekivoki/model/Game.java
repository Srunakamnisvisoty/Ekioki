package game.ekivoki.model;

import game.ekivoki.model.parent.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game extends BaseEntity {

    private Long sessionId;
    private Long cardId;
}
