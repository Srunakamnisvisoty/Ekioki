package game.ekivoki.service.impl;

import game.ekivoki.exception.EntityNotFoundException;
import game.ekivoki.model.Question;
import game.ekivoki.repository.dao.QuestionRepository;
import game.ekivoki.repository.dao.impl.QuestionRepositoryImpl;
import game.ekivoki.service.QuestionService;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl() {
        this.questionRepository = new QuestionRepositoryImpl();
    }

    @Override
    public Question findOne(Long id) {
        return questionRepository.findOne(id).orElseThrow(
                () -> new EntityNotFoundException("Question not found by id: " + id)
        );
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question save(Question question) {
        return question.getId() == null ?
                questionRepository.create(question).orElseThrow(EntityNotFoundException::new) :
                questionRepository.update(question).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void remove(Long id) {
        questionRepository.remove(id);
    }
}
