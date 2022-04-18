/**
 * Main class
 * to run project
 */
package task10;

import task10.entity.HomeTask;
import task10.entity.Person;
import task10.entity.Task;
import task10.entity.WorkTask;
import task10.util.HibernateUtil;
import javax.persistence.EntityManager;
import java.time.LocalDate;

public class Main {
    public static final double COST_FOR_HOME_TASK = 125D;

    public static void main(final String[] args) {
        Task homeTask = HomeTask.builder()
                .startDate(LocalDate.of(2022,4,10))
                .endDate(LocalDate.of(2022,4,12))
                .executorPerson(new Person("Maria", "Petrova"))
                .observerPerson(new Person("Tamara", "Ivanova"))
                .name("Task1")
                .description("Homework")
                .build();
        Task workTask = WorkTask.builder()
                .name("Task2")
                .description("WorkTask")
                .cost(COST_FOR_HOME_TASK)
                .build();

        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(homeTask);
        em.persist(workTask);
        em.getTransaction().commit();
        em.close();
    }
}
