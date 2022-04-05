package game.ekivoki.converter;

import game.ekivoki.dto.QuestionDto;
import game.ekivoki.model.Question;

public interface QuestionConverter {

    QuestionDto convert(Question source);

    Question convert(QuestionDto source);
}
