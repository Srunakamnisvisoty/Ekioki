package game.ekivoki.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDto {

    private Long id;
    private TopicDto topic;
    private QuestionDto questionId;
    private int number;
    private String question;
    private int leadTime;
    private String dateCreation;
    private String lastModified;
    private Long version;


}
