package game.ekivoki.repository.dao;

import game.ekivoki.model.Topic;
import game.ekivoki.repository.JdbcRepository;

import java.util.Optional;

public interface TopicRepository extends JdbcRepository<Topic> {

    Optional<Topic> update(Topic topic);

    void remove(Long id);
}
