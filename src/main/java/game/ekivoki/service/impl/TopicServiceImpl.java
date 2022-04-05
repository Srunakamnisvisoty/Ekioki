package game.ekivoki.service.impl;

import game.ekivoki.exception.EntityNotFoundException;
import game.ekivoki.model.Topic;
import game.ekivoki.repository.dao.TopicRepository;
import game.ekivoki.repository.dao.impl.TopicRepositoryImpl;
import game.ekivoki.service.TopicService;

import java.util.List;

public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    public TopicServiceImpl() {
        this.topicRepository = new TopicRepositoryImpl();
    }

    @Override
    public Topic findOne(Long id) {
        return topicRepository.findOne(id).orElseThrow(
                () -> new EntityNotFoundException("Item not found by id: " + id)
        );
    }

    @Override
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        topicRepository.remove(id);
    }
}
