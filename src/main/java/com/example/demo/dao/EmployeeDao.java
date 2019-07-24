package com.example.demo.dao;

import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class EmployeeDao {
    private  static Map<Integer, Employee> employees = null;

    private  DepartmentDao departmentDao;
    static {

        employees = new HashMap<Integer, Employee>();
        employees.put(1001, new Employee(1001, "E-AA", "aa163@.com", 1, new Department(101,"D-AA")));
        employees.put(1001, new Employee(1002, "E-BB", "bb163@.com", 2, new Department(102,"D-BB")));
        employees.put(1001, new Employee(1003, "E-CC", "cc163@.com", 3, new Department(103,"D-CC")));
        employees.put(1001, new Employee(1004, "E-DD", "dd163@.com", 4, new Department(104,"D-DD")));
        employees.put(1001, new Employee(1005, "E-EE", "ee163@.com", 5, new Department(105,"D-EE")));
    }
    private  static Integer iniiId = 1006;
    public  void  save(Employee employee){
        if (employee.getId()==null){
            employee.setId(iniiId++);
        }
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
}
