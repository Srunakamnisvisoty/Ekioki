package game.ekivoki.model;

import game.ekivoki.model.parent.LogEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card extends LogEntity {

    private Long topicId;
    private Long questionId;
    private int number;
    private String question;
    private int leadTime;
}
