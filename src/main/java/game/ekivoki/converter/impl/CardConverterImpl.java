package game.ekivoki.converter.impl;

import game.ekivoki.converter.CardConverter;
import game.ekivoki.dto.CardDto;
import game.ekivoki.model.Card;
import game.ekivoki.util.DateUtils;

public class CardConverterImpl implements CardConverter {

    @Override
    public CardDto convert(Card source) {
        if (source == null) {
            return null;
        }
        CardDto target = new CardDto();
        target.setId(source.getId());
        target.setTopicId(source.getTopicId());
        target.setQuestionId(source.getQuestionId());
        target.setNumber(source.getNumber());
        target.setQuestion(source.getQuestion());
        target.setLeadTime(source.getLeadTime());
        target.setDateCreation(DateUtils.getDate(source.getDateCreation()));
        target.setLastModified(DateUtils.getDate(source.getLastModified()));
        target.setVersion(source.getVersion());
        return target;
    }

    @Override
    public Card convert(CardDto source) {
        if (source == null) {
            return null;
        }
        Card target = new Card();
        target.setId(source.getId());
        target.setTopicId(source.getTopicId());
        target.setQuestionId(source.getQuestionId());
        target.setNumber(source.getNumber());
        target.setQuestion(source.getQuestion());
        target.setLeadTime(source.getLeadTime());
        return target;
    }
}
