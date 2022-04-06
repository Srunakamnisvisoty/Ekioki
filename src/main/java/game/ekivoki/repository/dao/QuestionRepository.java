package game.ekivoki.repository.dao;

import game.ekivoki.model.Question;
import game.ekivoki.repository.JdbcRepository;

import java.util.Optional;

public interface QuestionRepository extends JdbcRepository<Question> {

    Optional<Question> update(Question question);
}
