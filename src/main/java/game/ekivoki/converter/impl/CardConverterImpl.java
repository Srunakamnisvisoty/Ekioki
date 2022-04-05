package game.ekivoki.converter.impl;

import game.ekivoki.converter.CardConverter;
import game.ekivoki.converter.QuestionConverter;
import game.ekivoki.converter.TopicConverter;
import game.ekivoki.dto.CardDto;
import game.ekivoki.dto.QuestionDto;
import game.ekivoki.dto.TopicDto;
import game.ekivoki.model.Card;
import game.ekivoki.model.Question;
import game.ekivoki.model.Topic;
import game.ekivoki.service.QuestionService;
import game.ekivoki.service.TopicService;
import game.ekivoki.service.impl.QuestionServiceImpl;
import game.ekivoki.service.impl.TopicServiceImpl;
import game.ekivoki.util.DateUtils;

public class CardConverterImpl implements CardConverter {

    private final TopicConverter topicConverter;
    private final QuestionConverter questionConverter;
    private final TopicService topicService;
    private final QuestionService questionService;


    public CardConverterImpl() {
        this.questionService = new QuestionServiceImpl();
        this.questionConverter = new QuestionConverterImpl();
        this.topicService = new TopicServiceImpl();
        this.topicConverter = new TopicConverterImpl();
    }

    @Override
    public CardDto convert(Card source) {
        if (source == null) {
            return null;
        }
        Question question = questionService.findOne(source.getQuestionId());
        QuestionDto questionDto = questionConverter.convert(question);
        Topic topic = topicService.findOne(source.getTopicId());
        TopicDto topicDto = topicConverter.convert(topic);
        CardDto target = new CardDto();
        target.setId(source.getId());
        target.setTopic(topicDto);
        target.setQuestionId(questionDto);
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
        Question question = questionService.findOne(source.getId());
        QuestionDto questionDto = questionConverter.convert(question);
        Topic topic = topicService.findOne(source.getId());
        TopicDto topicDto = topicConverter.convert(topic);
        Card target = new Card();
        target.setId(source.getId());
        target.setTopicId(topic.getId());
        target.setQuestionId(question.getId());
        target.setNumber(source.getNumber());
        target.setQuestion(source.getQuestion());
        target.setLeadTime(source.getLeadTime());
        return target;
    }
}
