package com.iconma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iconma.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
