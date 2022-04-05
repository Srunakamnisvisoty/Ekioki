package game.ekivoki.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameSessionDto {

    private Long id;
    private String sessionUuid;
    private String dateCreation;

}
