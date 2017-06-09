package facade;

import entity.Grade;
import entity.Student;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

/**
 *
 * @author Joacim
 */
public class Facade {

    public EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public static void main(String[] args) {
        Persistence.generateSchema("pu", null);
        new Facade().starter();
    }

    private void starter() {
        
//        Grade g = new Grade("a",12);
//        addGrade(g);
        
        Student s = new Student();
        s.setAge(12);
        s.setBirthDate(Calendar.getInstance().getTime());
        s.setFirstName("joacim");
        s.setGrade(getGrade(1));
        s.setIsMarried(false);
        s.setLastName("vetterlain");
        s.setMatDate(Calendar.getInstance().getTime());
        s.setMatNr(1);
        s.setPersons(null);
        s.setSupervisor(null);
        addStudent(s);
    }

    public Student addStudent(Student s) {
        Student student = s;
        System.out.println(s);
        EntityManager em = getManager();
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } catch (RollbackException r) {
            System.out.println("something went wrong");
        } finally {
            em.close();
        }
        return student;
    }

    public void addGrade(Grade g) {
        EntityManager em = getManager();
        try {
            em.getTransaction().begin();
            em.persist(g);
            em.getTransaction().commit();
        } catch (RollbackException r) {
            System.out.println("something went wrong");
        } finally {
            em.close();
        }
    }

    public Grade getGrade(int id) {
        return getManager().find(Grade.class, id);
    }

    private EntityManager getManager() {
        return emf.createEntityManager();
    }
}
