package com.rp.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rp.management.model.Student;
import com.rp.management.model.Teacher;
import com.rp.management.service.TeacherService;

@Controller
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	
	
	@GetMapping("/allTeachers")
	public String getAllTeachers(Model model) {
		model.addAttribute("teachers", teacherService.getAllTeachers());
		return "teachers";
	}
	
	
	@GetMapping("/teachers/new")
	public String addTeacher(Model model) {
		Teacher teacher = new Teacher();
		model.addAttribute("teacher", teacher);
		return "create-teacher";
	}
	
	@PostMapping("/teacher")
	public String mainPage(@ModelAttribute("teacher") Teacher teacher) {
		
		teacherService.saveTeacher(teacher);		
		return "redirect:/allTeachers";
		
	}
	
	@GetMapping("teacher/edit{id}")
	public String editTeacherForm(@PathVariable int id, Model model) {
		model.addAttribute("teacher", teacherService.getTeacherById(id));
		return "update-teacher";	
	}
	
	@PostMapping("/teacher/{id}")
	public String updateTeacher(@PathVariable int id, @ModelAttribute("teacher") Teacher teacher, Model model) {
		Teacher existingTeacher = teacherService.getTeacherById(id);
		existingTeacher.setId(id);
		existingTeacher.setAddress(teacher.getAddress());
		existingTeacher.setEmail(teacher.getEmail());
		existingTeacher.setName(teacher.getName());
		existingTeacher.setSpecialization(teacher.getSpecialization());
		
		teacherService.updaTeacher(existingTeacher);
		
		return "redirect:/allTeachers";
	}
	
	@GetMapping("teacher/delete{id}")
	public String deleteTeacher(@PathVariable int id) {
		teacherService.deleteTeacher(id);
		return "redirect:/allTeachers";
	}

}
