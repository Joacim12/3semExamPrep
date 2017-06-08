package facade;

import entity.Project;
import entity.ProjectUser;
import entity.Task;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

/**
 *
 * @author joaci
 */
public class ProjectFacade {

    private EntityManagerFactory emf;

    public ProjectFacade(String pu) {
        this.emf = Persistence.createEntityManagerFactory(pu);
    }

    public static void main(String[] args) {
        new ProjectFacade("PU").start();
    }

    public void start() {
//        ProjectUser user = new ProjectUser(null,"joacim","j@j2.dk","08-06-2017");
//        ProjectUser user = new ProjectUser(null,"joacim1","j@j1.dk","08-06-2017");
//        System.out.println(createUser(user));
//        System.out.println(findUser("joacim"));
//        System.out.println(getAllUsers());
//          Project project = new Project("first","good","now","now");
//          System.out.println(createProject(project));
//            ProjectUser user = getUser("joacim");
//            Project project = getProject("first");
//            project.addProjectUser(user);
//            updateProject(project);
//            Task t = new Task("First Task","Desc","Hours","Hused");
//            Project project = getProject("first");
//            project.addTask(t);
//            updateProject(project);

    }

    public Task createTask(Task task) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(task);
            em.getTransaction().commit();
        } catch (RollbackException e) {
            System.out.println("Something went wrong while creating user!");
        }
        em.close();
        return task;
    }

    public Project updateProject(Project project) {
        EntityManager em = getEntityManager();
        try {
        em.getTransaction().begin();
        em.merge(project);
        em.getTransaction().commit();
         } catch (RollbackException e) {
            System.out.println("Something went wrong while creating user!");
        }
        em.close();
        return project;
    }

    public Project getProject(String name) {
        return getEntityManager().find(Project.class, name);
    }

    public Project createProject(Project project) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(project);
            em.getTransaction().commit();
        } catch (RollbackException e) {
            System.out.println("Something went wrong while creating user!");
        }
        em.close();
        return project;
    }

    public List<ProjectUser> getAllUsers() {
        return getEntityManager().createQuery("SELECT p FROM ProjectUser p").getResultList();
    }

    public ProjectUser getUser(String userName) {
        return getEntityManager().find(ProjectUser.class, userName);
    }

    public ProjectUser createUser(ProjectUser user) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (RollbackException e) {
            System.out.println("Something went wrong while creating user!");
        }
        em.close();
        return user;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
