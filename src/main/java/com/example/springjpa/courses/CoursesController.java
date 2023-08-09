package com.example.springjpa.courses;
import com.example.springjpa.topics.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import java.util.List;

@RestController
public class CoursesController {

    @Autowired
    private CourseService coursesService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourse(@PathVariable String id){
        return coursesService.getAllCourse(id);
    }

    @RequestMapping("/topic/{topicId}/courses/{id}")
    public Optional<Course> getCourse(@PathVariable String id){
        return coursesService.getCourse(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/topic/{topicId}/courses/{id}")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", "")); // Set the topic using the provided topicId
        coursesService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT , value = "/coursess/{id}")
    public void updateCourse(@RequestBody Course courses , @PathVariable String id){
        coursesService.updateCourse(id,courses);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/coursess/{id}")
    public void deleteCourse(@PathVariable String id){
        coursesService.deleteCourse(id);
    }

}