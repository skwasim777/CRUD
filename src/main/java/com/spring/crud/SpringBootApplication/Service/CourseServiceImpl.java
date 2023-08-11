package com.spring.crud.SpringBootApplication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.crud.SpringBootApplication.Repo.CourseRepository;
import com.spring.crud.SpringBootApplication.binding.Course;

@Service 
public class CourseServiceImpl implements CourseService {
	private CourseRepository courseRepo;
	@Override
	public String upsert(Course course) {
		// upsert (insert and update based on PK)
		courseRepo.save(course);
		return "success";
	}

	@Override
	public Course getById(Integer id) {
		Optional<Course> findbyid = courseRepo.findById(id);
		if(findbyid.isPresent()) {
			return findbyid.get();
		}
		return null;
	}

	@Override
	public List<Course> getAllCourses() {
		
		return courseRepo.findAll();
	}

	@Override
	public String deletById(Integer id) {
		if(courseRepo.existsById(id)) {
			courseRepo.deleteById(id);
			return "Deleted Success";
		}
		else {
			return "No Record Founds";
		}
	}

}
