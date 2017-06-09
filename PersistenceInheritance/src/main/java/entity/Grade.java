package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Joacim
 */
@Entity
public class Grade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private int value;

    public Grade() {
    }

    public Grade(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Grade{" + "id=" + id + ", name=" + name + ", value=" + value + '}';
    }
    
    
}
