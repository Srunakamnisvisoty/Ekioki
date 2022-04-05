package game.ekivoki.service;

import game.ekivoki.model.Topic;

import java.util.List;

public interface TopicService {

    Topic findOne(Long id);

    List<Topic> findAll();

    void remove(Long id);

}
