package org.example.controller;

import org.example.model.Dependent;
import org.example.service.EmployeeService;
import org.example.model.Employee;
import org.example.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.WebServlet;
import java.util.List;


@Controller
public class EmployeeController {

    @Autowired
      private EmployeeServiceImpl employeeServiceImpl;



    @RequestMapping("/addEmployee")
    public String showAddEmployeeForm(Model model) {
        System.out.println("Welcome to addEmployee");
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeServiceImpl.addEmployee(employee);
        System.out.println("Returning ViewEmployee");
        return "redirect:/viewEmployees";
    }

    @GetMapping("/viewEmployees")
    public String viewEmployees(Model model) {
        model.addAttribute("employees", employeeServiceImpl.getAllEmployees());

        System.out.println("Returing value to jsp");
        System.out.println(employeeServiceImpl.getAllEmployees());
        return "viewEmployees";
    }

    //@RequestMapping("/addDependent")
    //public String showAddDependentForm(Model model) {
        //System.out.println("Welcome to addEmployee");
        //model.addAttribute("dependent", new Dependent());
        //return "addDependent";
    //}
    @GetMapping("/{id}/dependents")
    public String showDependents(@PathVariable Integer id, Model model) {
        List<Dependent> dependents = employeeService.getDependentsByEmployeeId(id);
        model.addAttribute("dependents", dependents);
        return "dependent-list"; // JSP page for displaying dependents
    }

    @PostMapping("/addDependent")
    public String addDependent(@ModelAttribute("dependent") Dependent dependent) {
        employeeServiceImpl.addDependent(dependent);
        System.out.println("Returning ViewEmployee");
        return "redirect:/viewEmployees";
    }
}
