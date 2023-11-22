package pro.sky.homework27.employees;

import java.util.Collection;

public interface EmployeesService {
    Employee add (String firstName, String lastName);
    Employee remove (String firstName, String lastName);
    Employee find (String firstName, String lastName);


    Collection<Employee> fullList();
}
