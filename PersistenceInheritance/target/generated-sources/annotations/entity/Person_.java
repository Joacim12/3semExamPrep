package entity;

import entity.Grade;
import entity.Person;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-24T12:21:44")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, Boolean> isMarried;
    public static volatile ListAttribute<Person, Person> persons;
    public static volatile SingularAttribute<Person, String> firstName;
    public static volatile SingularAttribute<Person, String> lastName;
    public static volatile SingularAttribute<Person, Person> person;
    public static volatile SingularAttribute<Person, Grade> grade;
    public static volatile SingularAttribute<Person, Integer> id;
    public static volatile SingularAttribute<Person, Date> birthDate;
    public static volatile SingularAttribute<Person, Integer> age;

}