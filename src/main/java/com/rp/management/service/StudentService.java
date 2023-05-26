package com.rp.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rp.management.model.Student;
import com.rp.management.repository.StudentRepository;

import java.util.*;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public List <Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Student getStudentById(int id) {
		return studentRepository.findById(id).orElse(null);
	}
	
	public Student updateStudent(Student student) {
		
		return studentRepository.save(student);
	}
	
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
		
	}

}
