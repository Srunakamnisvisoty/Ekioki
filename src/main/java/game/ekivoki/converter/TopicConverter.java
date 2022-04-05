package game.ekivoki.converter;

import com.geninc.ekivoki.dto.TopicDto;
import com.geninc.ekivoki.model.Topic;

public interface TopicConverter {

    TopicDto convert(Topic source);

    Topic convert(TopicDto source);
}
