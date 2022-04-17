package task10.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
@Data
@Table(name = "HOME_TASK")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@PrimaryKeyJoinColumn(name = "TASK_ID")
public class HomeTask extends Task {
    @Column
    private LocalDate startDate;
    @Column
    private LocalDate endDate;

    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "executorName")),
            @AttributeOverride(name = "surname", column = @Column(name = "executorSurname"))
    })

    @Embedded
    private Person executorPerson;
    @Embedded
    private Person observerPerson;


}
