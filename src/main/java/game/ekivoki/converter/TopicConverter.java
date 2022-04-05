package game.ekivoki.converter;

import game.ekivoki.dto.TopicDto;
import game.ekivoki.model.Topic;

public interface TopicConverter {

    TopicDto convert(Topic source);

    Topic convert(TopicDto source);
}
