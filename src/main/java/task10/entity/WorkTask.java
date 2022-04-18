package task10.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Class WorkTask
 */
@Data
@Entity
@Table(name = "WORK_TASK")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("W")
public class WorkTask extends Task {
    private final static long serialVersionUID= 4L;
    @Column
    private Double cost;
}
