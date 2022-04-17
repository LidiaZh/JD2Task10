package task10.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name="TASK")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Task {
    @Id
    @GeneratedValue
    @Column(name = "TASK_ID")
    private Integer id;
    @Column(name = "task_name")
    private String name;
    @Column
    private String description;
}
