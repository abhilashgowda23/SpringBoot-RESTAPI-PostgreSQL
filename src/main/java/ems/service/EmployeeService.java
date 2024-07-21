//package emsemployeemanage.employeedao.service;
//
//import emsemployeemanage.employeedao.entity.Employee;
//import emsemployeemanage.employeedao.repository.EmployeeRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class EmployeeService {
//
//    EmployeeRepository employeeRepository;
//
//
//    public List<Employee> getAllEmployees() {
//
//        return employeeRepository.findAll();
//
//    }
//
//    public Employee saveBooks(Employee employee) {
//
//        return employeeRepository.save(employee);
//
//    }
//
//    public Employee updateBooks(Employee employee,Long id) {
//     Long employee1= employeeRepository.findById(id).orElseThrow(()->new RuntimeException()).getId();
//
//        return employeeRepository.save(employee);
//
//    }
//
//
//}
