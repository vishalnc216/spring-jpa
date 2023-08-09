package com.example.springjpa.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoursesController {
    @Autowired
    private CourseService courseService;
    @RequestMapping("/Topics/{Id}/Courses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();

    }
    @RequestMapping("/topic/{topicid}/course/{Id}")
    public Course getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }
    @RequestMapping(method = RequestMethod.POST ,value = "/topic/{topicid}/course/{Id}")
    public  void addTop(@RequestBody Course course){
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topic/{topicid}/course/{Id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id){
        courseService.updateCourse(course,id);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="/topic/{topicid}/course/{Id}")
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }

}
