package com.rp.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rp.management.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
