package game.ekivoki.service;

import game.ekivoki.model.Question;
import game.ekivoki.model.Topic;

import java.util.List;

public interface TopicService {

    Topic findOne(Long id);

    List<Topic> findAll();

    Topic save(Topic topic);

    void remove(Long id);

}
