package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CollegeRepository;
import com.example.demo.entity.College;

@Service
public class CollegeServices {
	
	@Autowired 
	private CollegeRepository collegeRepo;
	
	public List<College> getAllColleges() {
        return collegeRepo.findAll();
    }

    public College getCollegeById(Long id) {
        return collegeRepo.findById(id).orElseThrow(() -> new RuntimeException("College not found"));
    }

    public College createCollege(College college) {
        return collegeRepo.save(college);
    }

    public College updateCollege(Long id, College updatedCollege) {
        College college = getCollegeById(id);
        college.setCollegeName(updatedCollege.getCollegeName());
        college.setLocation(updatedCollege.getLocation());
        return collegeRepo.save(college);
    }

    public void deleteCollege(Long id) {
        collegeRepo.deleteById(id);
    }
}
