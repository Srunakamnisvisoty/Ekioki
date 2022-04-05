package game.ekivoki.converter.impl;

import com.geninc.ekivoki.converter.QuestionConverter;
import com.geninc.ekivoki.dto.QuestionDto;
import com.geninc.ekivoki.model.Question;

public class QuestionConverterImpl implements QuestionConverter {

    @Override
    public QuestionDto convert(Question source) {
        if (source == null) {
            return null;
        }
        QuestionDto target = new QuestionDto();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        return target;
    }

    @Override
    public Question convert(QuestionDto source) {
        if (source == null) {
            return null;
        }
        Question target = new Question();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        return target;
    }
}