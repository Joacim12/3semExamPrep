package entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;

/**
 *
 * @author Joacim
 */
@Entity
public class Student extends Person {    

    public Student(int matNr, Date matDate, Grade grade, String firstName, String lastName, Date birthDate, int age, boolean isMarried) {
        super(firstName, lastName, birthDate, age, isMarried);
        this.matNr = matNr;
        this.matDate = matDate;
    }
    
    public Student(){
    }
    
    private int matNr;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date matDate;  

    public void setMatNr(int matNr) {
        this.matNr = matNr;
    }

    public void setMatDate(Date matDate) {
        this.matDate = matDate;
    }
    
}
