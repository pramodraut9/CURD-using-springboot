package com.CURD.RestContrroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CURD.Entity.Student;


import com.CURD.StudentService.StudentServiceImpl;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	@Autowired
	private StudentServiceImpl studentServiceImpl;


	@RequestMapping("/students")
	public List<Student> NameAll() {

		return studentServiceImpl.NameAll();
	}

	
	@RequestMapping("/students/{id}")
	public Optional<Student> getStudent(@PathVariable int id) {

		Optional<Student> thestudent = studentServiceImpl.findById(id);

		if (thestudent == null) {

			throw new RuntimeException("Student Id not found :--" + id);
		}
		return thestudent;

	}

	
	@PostMapping("/students")
	public Student addstudent(@RequestBody Student thestudent) {

		thestudent.setId(0);

		studentServiceImpl.Save(thestudent);

		return thestudent;

	}

	
	@PutMapping("/students")
	public Student updatestudent(@RequestBody Student thestudent) {

		studentServiceImpl.Save(thestudent);

		return thestudent;

	}

	
	@DeleteMapping("/students/{id}")
	public String DeleteStudent(@PathVariable int id) {

		Optional<Student> thestudent = studentServiceImpl.findById(id);

		if (thestudent == null) {

			throw new RuntimeException("Student Id not found :--" + id);
		}
		studentServiceImpl.DeleteById(id);

		return "Deleted Student Id:--" + id;

	}

}
