package ems.controller;

import ems.entity.EmployeeEntity;
import ems.exception.ResourceNotFoundException;
import ems.model.EmployeeModel;
import ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/getallemployees")
    private List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/get-all-employees-by-id/{id}")
    private ResponseEntity<EmployeeEntity> getAllEmployeeById(@PathVariable(value = "id") Long empId) throws ResourceNotFoundException {
        EmployeeEntity employee = employeeRepository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("employee not found for id  : " + empId));
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping(path = "/create-employee", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    private EmployeeEntity createEmployee(@RequestBody EmployeeModel emp) {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setFirstName(emp.getFirstName());
        employee.setLastName(emp.getFirstName());
        employee.setEmail_id(emp.getEmail_id());

        return employeeRepository.save(employee);
    }


//    @PostMapping("/create-employees")
//    private void createEmployees(@RequestBody List<EmployeeModel> empList) {
//
//       employeeRepository.saveAll(empList);
//
//    }

    @PutMapping("/update-employee/{id}")
    private EmployeeEntity updateEmployees(@PathVariable(value = "id") Long id, EmployeeModel employeeDetails) throws ResourceNotFoundException {
        EmployeeEntity fetchedEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee not found for id : " + id));
        fetchedEmployee.setFirstName(employeeDetails.getFirstName());
        fetchedEmployee.setLastName(employeeDetails.getLastName());
        // fetchedEmployee.setEmail(employeeDetails.getEmail());
        return employeeRepository.save(fetchedEmployee);


    }

//    @PutMapping
//    public void updateEmployee(@PathVariable Long id,EmployeeModel employeeModel){
//       EmployeeEntity employee= employeeRepository.findById(id).orElseThrow(()->new RuntimeException("s"));
//       employee.setId(employeeModel.getId());
//       employee.setEmail_id();
//
//    }

    @DeleteMapping("/delete-employee/{id}")
    private EmployeeEntity deleteEmployees(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        EmployeeEntity fetchedEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee not found for id : " + id));

        employeeRepository.delete(fetchedEmployee);
        return ResponseEntity.ok(fetchedEmployee).getBody();
    }


}
