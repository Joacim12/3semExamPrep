package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-24T12:21:44")
@StaticMetamodel(Employee.class)
public class Employee_ extends Person_ {

    public static volatile SingularAttribute<Employee, String> taxClass;
    public static volatile SingularAttribute<Employee, Integer> soSecNr;
    public static volatile SingularAttribute<Employee, Float> wage;

}