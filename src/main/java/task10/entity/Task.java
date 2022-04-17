package task10.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@SuperBuilder
@Table(name="TASK")
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Task {
    private final static long serialVersionUID= 1L;
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "task_name")
    private String name;
    @Column
    private String description;
}
