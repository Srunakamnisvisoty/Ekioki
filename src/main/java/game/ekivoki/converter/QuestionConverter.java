package game.ekivoki.converter;

import com.geninc.ekivoki.dto.QuestionDto;
import com.geninc.ekivoki.model.Question;

public interface QuestionConverter {

    QuestionDto convert(Question source);

    Question convert(QuestionDto source);
}
