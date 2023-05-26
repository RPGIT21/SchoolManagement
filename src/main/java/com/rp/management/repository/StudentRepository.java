package com.rp.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rp.management.model.Student;


public interface StudentRepository extends JpaRepository<Student, Integer> {

}
