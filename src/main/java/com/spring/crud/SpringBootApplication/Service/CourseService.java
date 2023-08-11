package com.spring.crud.SpringBootApplication.Service;

import java.util.List;

import com.spring.crud.SpringBootApplication.binding.Course;

public interface CourseService {
		public String upsert(Course course);
		public Course getById(Integer id);
		public List<Course> getAllCourses();
		public String deletById(Integer id);
}	
