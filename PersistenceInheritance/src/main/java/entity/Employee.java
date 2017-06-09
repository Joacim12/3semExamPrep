package entity;

import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author Joacim
 */
@Entity
public class Employee extends Person{
    
    private int soSecNr;
    private float wage;
    private String taxClass;

    public Employee() {
    }

    public Employee(int soSecNr, float wage, String taxClass, Grade grade, String firstName, String lastName, Date birthDate, int age, boolean isMarried) {
        super(firstName, lastName, birthDate, age, isMarried);
        this.soSecNr = soSecNr;
        this.wage = wage;
        this.taxClass = taxClass;
    }

    
    
}
