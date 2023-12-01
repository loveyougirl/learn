package lamdba.stream.map2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamToMap {
    @Test
    public void testStreamMap_duplicateKey() {
        Employee employee = Employee.builder().id(1).age(20).firstName("zhang").build();
        Employee employee1 = Employee.builder().id(2).age(21).firstName("Li").build();
        Employee employee2 = Employee.builder().id(3).age(22).firstName("Li").build();
        Employee employee3 = Employee.builder().id(4).age(23).firstName("Chen").build();
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        Map<String, Integer> dataMap = employees.stream().collect(Collectors.toMap(e -> e.getFirstName(), e -> e.getAge()));
        //Duplicate Key
        Map<Integer, Employee> employeeMap = employees.stream().collect(Collectors.toMap(e -> e.getAge(), e -> e));
    }

    @Test
    public void testStreamMap() {
        Employee employee = Employee.builder().id(1).age(20).firstName("zhang").build();
        Employee employee1 = Employee.builder().id(2).age(21).firstName("Li").build();
        Employee employee2 = Employee.builder().id(3).age(22).firstName("Li").build();
        Employee employee3 = Employee.builder().id(4).age(23).firstName("Chen").build();
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        Map<String, Integer> dataMap = employees.stream().collect(Collectors.toMap(e -> e.getFirstName(), e -> e.getAge(), (k1, k2)-> k1));
        Map<Integer, Employee> employeeMap = employees.stream().collect(Collectors.toMap(e->e.getAge(), e->e, (k1, k2) -> k1));
    }
}
