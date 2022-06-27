package task10.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Class HomeTask extends Task
 */
@Data
@Table(name = "HOME_TASK")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class HomeTask extends Task {
    private final static long serialVersionUID = 3L;
    /**
     * Date when task starts
     */
    @Column
    private LocalDate startDate;
    /**
     * Date when task ends
     */
    @Column
    private LocalDate endDate;

    @AttributeOverrides({
            @AttributeOverride(name = "name",
                    column = @Column(name = "executorName")),
            @AttributeOverride(name = "surname",
                    column = @Column(name = "executorSurname"))
    })

    @Embedded
    private Person executorPerson;
    @Embedded
    private Person observerPerson;
}
