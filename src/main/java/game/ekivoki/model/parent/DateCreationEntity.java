package game.ekivoki.model.parent;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class DateCreationEntity extends BaseEntity {

    private Date dateCreation;
}
