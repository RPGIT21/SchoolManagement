package com.rp.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rp.management.model.Student;
import com.rp.management.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/allStudents")
	public String getAllStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	
	@GetMapping("/students/new")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create-student";
	}
	
	@PostMapping("/student")
	public String mainPage(@ModelAttribute("student") Student student) {
		
		studentService.saveStudent(student);
		
		return "redirect:/allStudents";
		
	}
	
	@GetMapping("student/edit{id}")
	public String editStudentForm(@PathVariable int id, Model model) {
		//Student student = studentService.getStudentById(id);
		model.addAttribute("student", studentService.getStudentById(id));
		return "update-student";	
	}
	
	@PostMapping("/student/{id}")
	public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student, Model model) {
		Student existinStudent = studentService.getStudentById(id);
		existinStudent.setId(id);
		existinStudent.setAddress(student.getAddress());
		existinStudent.setEmail(student.getEmail());
		existinStudent.setName(student.getName());
		
		studentService.updateStudent(existinStudent);
		
		return "redirect:/allStudents";
	}
	
	@GetMapping("student/delete{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
		return "redirect:/allStudents";
	}
	
	@GetMapping("/")
	public String homePage() {
		return "home-page";
	}
	

}
