package game.ekivoki.converter.impl;

import com.geninc.ekivoki.converter.TopicConverter;
import com.geninc.ekivoki.dto.TopicDto;
import com.geninc.ekivoki.model.Topic;

public class TopicConverterImpl implements TopicConverter {

    @Override
    public TopicDto convert(Topic source) {
        if (source == null) {
            return null;
        }
        TopicDto target = new TopicDto();
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }

    @Override
    public Topic convert(TopicDto source) {
        if (source == null) {
            return null;
        }
        Topic target = new Topic();
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }
}
