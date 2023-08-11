package com.springboot.resController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.spring.crud.SpringBootApplication.Repo.CourseRepository;
import com.spring.crud.SpringBootApplication.Service.CourseService;
import com.spring.crud.SpringBootApplication.binding.Course;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@RestController
public class CourseRestController {
	   
		@Autowired
		private CourseService courseService;
	    @PostMapping("/course")
	    public ResponseEntity<String> createCourse(@RequestBody Course course){
	    	String status=courseService.upsert(course);
	    	return new ResponseEntity<>(status,HttpStatus.CREATED);
	    }
	    @GetMapping("/course/{id}")
	    public ResponseEntity<Course> getCourse(Integer id){
	    	Course course = courseService.getById(id);
	    	return new ResponseEntity<>(course,HttpStatus.OK);
	    }
	    public ResponseEntity<List<Course>> getAllCourses(){
	    	List<Course> allcourses = courseService.getAllCourses();
	    	return new ResponseEntity<>(allcourses,HttpStatus.OK);
	    }
	    @PutMapping("/course")
	    public ResponseEntity<String> updateCourse(@RequestBody Course course){
	    	String status = courseService.upsert(course);
	    	return new ResponseEntity<>(status,HttpStatus.OK);
	    }
	    @DeleteMapping("/course/{id}")
	    public ResponseEntity<String> deleteCourse(@PathVariable Integer id){
	    	String status = courseService.deletById(id);
	    	return new ResponseEntity<>(status,HttpStatus.OK);
	    }
}
