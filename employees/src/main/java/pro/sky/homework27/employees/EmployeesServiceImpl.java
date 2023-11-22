package pro.sky.homework27.employees;

import pro.sky.homework27.employees.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework27.employees.exceptions.EmployeeNotFoundException;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class EmployeesServiceImpl implements EmployeesService {
    private final Map<String, Employee> employeesMap;

    public EmployeesServiceImpl(Map<String, Employee> employeesMap) {
        this.employeesMap = employeesMap;
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeesMap.containsKey(employee.getFullName())){
            throw new EmployeeAlreadyAddedException();
        }
        employeesMap.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeesMap.containsKey(employee.getFullName())) {
            return employeesMap.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeesMap.containsKey(employee.getFullName())) {
            return employeesMap.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> fullList() {
        return Collections.unmodifiableCollection(employeesMap.values());
    }
}
