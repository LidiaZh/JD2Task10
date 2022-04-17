package task10;

import task10.entity.HomeTask;
import task10.entity.Person;
import task10.entity.Task;
import task10.entity.WorkTask;
import task10.util.HibernateUtil;
import javax.persistence.EntityManager;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Task homeTask = HomeTask.builder()
                .startDate(LocalDate.of(2022,04,10))
                .endDate(LocalDate.of(2022,04,12))
                .executorPerson(new Person("Maria", "Petrova"))
                .observerPerson(new Person("Tamara", "Ivanova"))
                .name("Task5")
                .description("Homework3")
                .build();
        Task workTask = WorkTask.builder()
                .name("Task6")
                .description("WorkTask3")
                .cost(125D)
                .build();

        Task task1 = Task.builder()
                .name("Task5")
                .description("Homework3")
                .build();
        Task task2 = Task.builder()
                .name("Task6")
                .description("WorkTask3")
                .build();

        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(homeTask);
        em.persist(workTask);
        em.persist(task1);
        em.persist(task2);
        em.getTransaction().commit();
        em.close();



    }
}
