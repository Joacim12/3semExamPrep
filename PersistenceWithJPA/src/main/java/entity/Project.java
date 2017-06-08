package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author joaci
 */
@Entity
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String name;
    private String description;
    private String created;
    private String lastModified;
    
    @OneToMany
    private List<Task> tasks = new ArrayList();
    
    @ManyToMany
    List<ProjectUser> projectUsers = new ArrayList();

    public Project() {
    }

    public Project(String name, String description, String created, String lastModified) {
        this.name = name;
        this.description = description;
        this.created = created;
        this.lastModified = lastModified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<ProjectUser> getProjectUsers() {
        return projectUsers;
    }

    public void addProjectUser(ProjectUser projectUser) {
        projectUsers.add(projectUser);
    }

    @Override
    public String toString() {
        return "Project{" + "name=" + name + ", description=" + description + ", created=" + created + ", lastModified=" + lastModified + ", tasks=" + tasks + ", projectUsers=" + projectUsers + '}';
    }
    
    

    
}
