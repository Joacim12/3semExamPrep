package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author joaci
 */
@Entity
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String name;
    private String description;
    private String hoursAssigned;
    private String hoursUsed;

    public Task() {
    }

    public Task(String name, String description, String hoursAssigned, String hoursUsed) {
        this.name = name;
        this.description = description;
        this.hoursAssigned = hoursAssigned;
        this.hoursUsed = hoursUsed;
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

    public String getHoursAssigned() {
        return hoursAssigned;
    }

    public void setHoursAssigned(String hoursAssigned) {
        this.hoursAssigned = hoursAssigned;
    }

    public String getHoursUsed() {
        return hoursUsed;
    }

    public void setHoursUsed(String hoursUsed) {
        this.hoursUsed = hoursUsed;
    }

    @Override
    public String toString() {
        return "Task{" + "name=" + name + ", description=" + description + ", hoursAssigned=" + hoursAssigned + ", hoursUsed=" + hoursUsed + '}';
    }
    
    
}
