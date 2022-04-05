package game.ekivoki.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDto {

    private Long id;
    private Long topicId;
    private Long questionId;
    private int number;
    private String question;
    private int leadTime;
    private String dateCreation;
    private String lastModified;
    private Long version;
}
