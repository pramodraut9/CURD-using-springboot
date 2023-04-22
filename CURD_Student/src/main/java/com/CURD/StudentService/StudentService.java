package com.CURD.StudentService;

import java.util.List;
import java.util.Optional;

import com.CURD.Entity.Student;

public interface StudentService {

    public List<Student> NameAll();
	
	public Optional<Student> findById(int theId);
	
	public void Save (Student thestudent);
	
	 public String DeleteById(int theId ); 
	
	
	
}
