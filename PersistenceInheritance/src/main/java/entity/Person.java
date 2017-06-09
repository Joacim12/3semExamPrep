package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Joacim
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Serializable {
   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer id;    
    
    @ManyToOne
    private Person supervisor;
    @OneToMany(mappedBy = "supervisor")
    private List<Person> persons;
    
    @OneToOne
    private Grade grade;
       
    private String firstName;
    private String lastName;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthDate;
    private int age;
    private boolean isMarried;    

    public Person() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSupervisor(Person supervisor) {
        this.supervisor = supervisor;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIsMarried(boolean isMarried) {
        this.isMarried = isMarried;
    }

    public Person(String firstName, String lastName, Date birthDate, int age, boolean isMarried) {
        this.grade = grade;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.age = age;
        this.isMarried = isMarried;
    }
    
    
    

    public Integer getId() {
        return id;
    }
    
}
