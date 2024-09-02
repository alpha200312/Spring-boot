package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CollegeRepository;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.entity.College;
import com.example.demo.entity.Student;

@Service
public class StudentServices {
	@Autowired
	StudentRepository studentRepo;
	@Autowired 
	CollegeRepository collegeRepo;
	
	
	public Student addStudent(Student student) {
		return studentRepo.save(student);
		
		
	}
	
	
	public List<Student> getAllstudents(){
		return studentRepo.findAll();
	}
	
	public Student getStudentById(int id) {
		return studentRepo.findById(id).orElseThrow();
		
		
	}
	public void deletestudent(int id) {
		studentRepo.deleteById(id);
		
	}
	
	public Student updateStudent(int id,Student up) {
		Student student =getStudentById(id);
		
		student.setName(up.getName());
        student.setRoll(up.getRoll());
        student.setQualification(up.getQualification());
        student.setCourse(up.getCourse());
        student.setYear(up.getYear());
        student.setHallTicketNo(up.getHallTicketNo());
        
        if(up.getCollege()!=null) {
        	College college=collegeRepo.findById(up.getCollege().getId()).orElse(null);
        	student.setCollege(college);
        	
        }
      return   studentRepo.save(student);
        
	}

}
