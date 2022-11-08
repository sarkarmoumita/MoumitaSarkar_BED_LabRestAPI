package com.greatlearning.studentManagement.service;

import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.greatlearning.studentManagement.entity.Student;
import com.greatlearning.studentManagement.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {


	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		List<Student> students=studentRepository.findAll();
		return students;
	}

	@Override
	public Student findById(int theId) {
		return studentRepository.findById(theId).get();
	}

	@Override
	public void save(Student theStudent) {
		studentRepository.save(theStudent);
		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(theId);
	}
}