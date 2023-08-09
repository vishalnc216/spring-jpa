package com.example.springjpa.courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;




    public List<Course> getAllCourses(){
        List <Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id){
        return courseRepository.findById(id).orElse(null);

    }

    public  void addCourse(Course course){

        courseRepository.save(course);
    }

    public void updateCourse(Course course, String id){


        courseRepository.save(course);
    }


    public void deleteCourse(String id){
        courseRepository.deleteById(id);
    }
}
