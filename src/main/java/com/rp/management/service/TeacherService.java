package com.rp.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rp.management.model.Teacher;
import com.rp.management.repository.TeacherRepository;

@Service
public class TeacherService {
	@Autowired
	private TeacherRepository teacherRepository;
	
	public Teacher saveTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}
	
	public List<Teacher> getAllTeachers(){
		return teacherRepository.findAll();
	}
	
	public Teacher getTeacherById(int id) {
		return teacherRepository.findById(id).orElse(null);
	}
	
	public Teacher updaTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}
	
	public void deleteTeacher(int id) {
		teacherRepository.deleteById(id);
	}

}
