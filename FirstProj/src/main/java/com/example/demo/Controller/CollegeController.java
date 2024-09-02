package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.CollegeServices;
import com.example.demo.entity.College;

@RestController

public class CollegeController {
	
	@Autowired
	private CollegeServices collegeService;
	
	 @GetMapping("/getallcoll")
	    public List<College> getAllColleges() {
	        return collegeService.getAllColleges();
	    }

	    @GetMapping("/{id}")
	    public College getCollegeById(@PathVariable Long id) {
	        return collegeService.getCollegeById(id);
	    }

	    @PostMapping("/createcoll")
	    public College createCollege(@RequestBody College college) {
	        return collegeService.createCollege(college);
	    }

	    @PutMapping("/upadatecollege/{id}")
	    public College updateCollege(@PathVariable Long id, @RequestBody College college) {
	        return collegeService.updateCollege(id, college);
	    }

	    @DeleteMapping("/deletecollege/{id}")
	    public void deleteCollege(@PathVariable Long id) {
	        collegeService.deleteCollege(id);
	    }
}
