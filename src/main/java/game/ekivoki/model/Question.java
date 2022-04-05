package game.ekivoki.model;

import com.geninc.ekivoki.model.parent.NameEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question extends NameEntity {

    private String description;
}
