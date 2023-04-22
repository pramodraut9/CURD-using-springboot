package com.CURD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CURD.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
