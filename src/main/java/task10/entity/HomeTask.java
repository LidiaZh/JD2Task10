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
public class HomeTask extends Task {
    private final static long serialVersionUID= 3L;
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
