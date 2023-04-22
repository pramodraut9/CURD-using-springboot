package com.CURD.StudentService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CURD.Entity.Student;
import com.CURD.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> NameAll() {

		return studentRepository.findAll();

	}

	@Override
	public Optional<Student> findById(int theId) {

		Optional<Student> students = studentRepository.findById(theId);

		if (students == null) {

			throw new RuntimeException("Student Not Found");
		}
		return students;

	}

	@Override
	public void Save(Student thestudent) {

		studentRepository.save(thestudent);
	}

	@Override
	public String DeleteById(int theId) {

		Optional<Student> students = studentRepository.findById(theId);

		if (students == null) {

			throw new RuntimeException("Student Not Found");
		}
		studentRepository.deleteById(theId);

		return "Deleted id : " + theId;

	}

}
