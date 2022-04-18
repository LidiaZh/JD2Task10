/**
 * Class HomeTask extends Task
 */
package task10.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Table(name = "HOME_TASK")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@javax.persistence.Entity
@javax.persistence.DiscriminatorValue("H")
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
    /**
     * Person for DB who execute task
    */
    @Embedded
    private Person executorPerson;
    /**
     * Person for DB who looking task
     */
    @Embedded
    private Person observerPerson;
}
