package task10;

import org.hibernate.HibernateException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import task10.entity.HomeTask;
import task10.entity.Person;
import task10.entity.Task;
import task10.entity.WorkTask;
import task10.util.HibernateUtil;
import javax.persistence.EntityManager;
import java.time.LocalDate;

/**
 * Unit test for simple App.
 */
public class MainTest extends Assert {
    @Test
    public void testHomeTask() {
        Task homeTask = HomeTask.builder()
                .startDate(LocalDate.of(2022, 3, 3))
                .endDate(LocalDate.of(2022, 3, 7))
                .executorPerson(new Person("Lilia", "Cvetkova"))
                .observerPerson(new Person("Maksim", "Petrov"))
                .name("Test1")
                .description("Homework11")
                .build();

        EntityManager em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(homeTask);
            em.getTransaction().commit();
        } catch (HibernateException e) {
            em.getTransaction().rollback();
        }

        em.getTransaction().begin();
        Task homeTaskFromDB = em.find(HomeTask.class, homeTask.getId());
        assertEquals("Id not equals", homeTask.getId(), homeTaskFromDB.getId());
        assertEquals("Name not equals", homeTask.getName(), homeTaskFromDB.getName());
        assertEquals("Description not equals", homeTask.getDescription(), homeTaskFromDB.getDescription());
        em.getTransaction().commit();
        em.close();
    }

    @Test
    public void testWorkTask() {
        Task workTask = WorkTask.builder()
                .name("Test2")
                .description("Homework12")
                .cost(111D)
                .build();

        EntityManager em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(workTask);
            em.getTransaction().commit();
        } catch (HibernateException e) {
            em.getTransaction().rollback();
        }

        em.getTransaction().begin();
        WorkTask workTaskFromDB = em.find(WorkTask.class, workTask.getId());
        assertEquals("Id not equals", workTask.getId(), workTaskFromDB.getId());
        assertEquals("Name not equals", workTask.getName(), workTaskFromDB.getName());
        assertEquals("Description not equals", workTask.getDescription(), workTaskFromDB.getDescription());
        em.getTransaction().commit();
        em.close();
    }

    @Test
    public void testTask() {
        Task task = WorkTask.builder()
                .name("Test3")
                .description("Homework13")
                .cost(111D)
                .build();

        EntityManager em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(task);
            em.getTransaction().commit();
        } catch (HibernateException e) {
            em.getTransaction().rollback();
        }

        em.getTransaction().begin();
        Task taskFromDB = em.find(Task.class, task.getId());
        assertEquals("Id not equals", task.getId(), taskFromDB.getId());
        assertEquals("Name not equals", task.getName(), taskFromDB.getName());
        assertEquals("Description not equals", task.getDescription(), taskFromDB.getDescription());
        em.getTransaction().commit();
        em.close();
    }

    @AfterClass
    public static void cleanUp() {
        HibernateUtil.close();
    }
}
