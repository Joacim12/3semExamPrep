package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author joaci
 */
@Entity
public class ProjectUser implements Serializable {

    @ManyToMany(mappedBy = "projectUsers")
    private List<Project> projects;

    private static final long serialVersionUID = 1L;
    
    @Id
    private String userName;
    private String email;
    private String created;

    public ProjectUser() {
    }

    public ProjectUser(List<Project> projects, String userName, String email, String created) {
        this.projects = projects;
        this.userName = userName;
        this.email = email;
        this.created = created;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "ProjectUser{" + "projects=" + projects + ", userName=" + userName + ", email=" + email + ", created=" + created + '}';
    }
    
    


    
}
