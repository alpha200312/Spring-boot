package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.StudentServices;
import com.example.demo.entity.Student;

@RestController
public class StudentController {
	 @Autowired
	    private StudentServices studentService;

	    @GetMapping
	    public List<Student> getAllStudents() {
	        return studentService.getAllstudents();
	    }

	    @GetMapping("/getstudent/{id}")
	    public Student getStudentById(@PathVariable int id) {
	        return studentService.getStudentById(id);
	    }

	    @PostMapping("/addstudent")
	    public Student createStudent(@RequestBody Student student) {
	        return studentService.addStudent(student);
	    }

	    @PutMapping("/updatestudent/{id}")
	    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
	        return studentService.updateStudent(id, student);
	    }

	    @DeleteMapping("/delete/{id}")
	    public void deleteStudent(@PathVariable int id) {
	        studentService.deletestudent(id);
	    }

}
