package pro.sky.homework27.employees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
    @RequestMapping("/employee")
    public class EmployeesController {
        public final EmployeesService employeesService;

        public EmployeesController(EmployeesService employeesService) {
            this.employeesService = employeesService;
        }
        @GetMapping("/add")
        public Employee addition (@RequestParam String firstName, @RequestParam String lastName){
            return employeesService.add(firstName, lastName);
        }
        @GetMapping("/remove")
        public Employee removing (@RequestParam String firstName, @RequestParam String lastName){
            return employeesService.remove(firstName, lastName);
        }
        @GetMapping("/find")
        public Employee finding (@RequestParam String firstName, @RequestParam String lastName){
            return employeesService.find(firstName, lastName);
        }
        @GetMapping
        public Collection<Employee> fullList(){
            return employeesService.fullList();
        }
}
