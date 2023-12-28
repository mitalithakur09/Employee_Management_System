package com.pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pro.entity.Employee;
import com.pro.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
  @Autowired
  private EmpService service ;
  
  @GetMapping("/home")
  public String home(Model m ) {
	  List<Employee> emp = service.getAllEmp();
	  m.addAttribute("emp", emp);
	  return "index.html";
  }
  
  @GetMapping("/addemp")
  public String addEmpForm() {
	  return "add_emp.html";
  }
  
  @PostMapping("/register")
  public String empRegister(@ModelAttribute Employee e, Model model, HttpSession session) {
	  
	  System.out.println(e);
	  service.addEmp(e);
	  session.setAttribute("msg","Employee added succesfully....!");
	  
	  return "redirect:/home";
  }
  
  @GetMapping("/edit/{id}")
  public String edit (@PathVariable int id,Model m) {
	  Employee e = service.getEmpById(id);
	  m.addAttribute("emp" , e);
	  return "edit";
	  
  }
  
  @PostMapping("/update")
  public String updateEmp(@ModelAttribute Employee e , HttpSession session) {
	  service.addEmp(e);
	  session.setAttribute("msg", "Emp data update Successfully");
	  return "redirect:/home";
  }
  
  @GetMapping("/delete/{id}")
  public String deleteEmp(@PathVariable int id , HttpSession session) {
	 service.deleteEmp(id);
	  session.setAttribute("msg", "Emp data delete Successfully");
	  return "redirect:/home";
  }

	
}

