package com.spring.crud.SpringBootApplication.Repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.crud.SpringBootApplication.binding.Course;

public interface CourseRepository extends JpaRepository<Course,Serializable>{

}
