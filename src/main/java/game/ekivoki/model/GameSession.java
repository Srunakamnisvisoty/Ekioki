package game.ekivoki.model;

import com.geninc.ekivoki.model.parent.DateCreationEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameSession extends DateCreationEntity {

    private String sessionUuid;
}
