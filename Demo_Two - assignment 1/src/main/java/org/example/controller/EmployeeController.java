package org.example.controller;

import org.example.entity.Dependent;
import org.example.entity.Employee;
import org.example.service.DependentServiceImpl;
import org.example.service.EmployeeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeServiceImpl employeeServiceimpl;

    @Autowired
    private DependentServiceImpl dependentServiceImpl;

    @GetMapping("/")
    public String welcomePage() {
        return "welcome";
    }

    @GetMapping("/add-employee")
    public String addEmployeePage(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    /*@PostMapping("/save-employee")
    public String saveEmployeeWithDependent(@ModelAttribute Employee employee) {
        System.out.println("Welcome to Save employee section");
        employeeServiceimpl.saveEmployee(employee);
        return "Welcome to Save employee section";
        //return "redirect:/viewEmployees";
    }*/

   /* @PostMapping("/save-employee")
    public String saveEmployee(@ModelAttribute Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            // Handle validation errors here
            return "addEmployee";
        }
        // Save employee if no errors
        employeeServiceimpl.saveEmployee(employee);
        return "redirect:/success";
    }*/

   /* @PostMapping("/save-employee")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employee.getDependents().forEach(dependent -> dependent.setDependent(employee));
        employeeServiceimpl.saveEmployee(employee);
        return "redirect:/view-employees";
    }*/

    @PostMapping("/save-employee")
    public String saveEmployee(@RequestParam String name, @RequestParam Integer age, @RequestParam String sex,
                               @RequestParam(name = "dependents[].name", required = false) List<String> dependentNames,
                               @RequestParam(name = "dependents[].age", required = false) List<Integer> dependentAges,
                               @RequestParam(name = "dependents[].sex", required = false) List<String> dependentSexes) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAge(age);
        employee.setSex(sex);

        if (dependentNames != null && dependentAges != null && dependentSexes != null) {
            List<Dependent> dependents = new ArrayList<>();
            for (int i = 0; i < dependentNames.size(); i++) {
                Dependent dependent = new Dependent();
                dependent.setName(dependentNames.get(i));
                dependent.setAge(dependentAges.get(i));
                dependent.setSex(dependentSexes.get(i));
                dependent.setDependent(employee);
                dependents.add(dependent);
            }
            employee.setDependents(dependents);
        }

        employeeServiceimpl.saveEmployee(employee);
        return "redirect:/view-employees";
    }


    @GetMapping("/view-employees")
    public String viewEmployees(Model model) {
        model.addAttribute("employees", employeeServiceimpl.getAllEmployees());
        return "viewEmployees";
    }

    /*@GetMapping("/{employeeId}/dependents")
    public ResponseEntity<List<Dependent>> getDependentsByEmployeeId(@PathVariable Long employeeId) {
        List<Dependent> dependents = dependentServiceImpl.getDependentsByEmployee(employee);

        if (dependents.isEmpty()) {
            return ResponseEntity.noContent().build(); // HTTP 204 No Content if no dependents are found
        }

        return ResponseEntity.ok(dependents); // HTTP 200 OK with dependents data
    }*/

    @GetMapping("/{employeeId}/dependents")
    public String getDependentsByEmployeeId(@PathVariable Long employeeId, Model model) {
        Optional<Employee> employeeOptional = employeeServiceimpl.getEmployeeByEmployeeId(employeeId);

        if (!employeeOptional.isPresent()) {
            return "Dependent Not Available !!"; // Redirect to employee list or another page if not found
        }

        List<Dependent> dependents = dependentServiceImpl.getDependentsByEmployee(employeeOptional.get());

        model.addAttribute("employee", employeeOptional.get());
        model.addAttribute("dependents", dependents); // Add dependents to the model

        return "viewDependent";// Return the JSP page name
    }





}
