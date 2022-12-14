package springboot.course.catalog.rest;

import springboot.course.catalog.dto.CourseDTO;
import springboot.course.catalog.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/courses")
@CrossOrigin
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCoursesDTO(){
        return new ResponseEntity<>(courseService.getAllCoursesDTO(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CourseDTO> getCourseDTO(@PathVariable(name="id") Long id){
        return new ResponseEntity<>(courseService.getCourseDTO(id), HttpStatus.OK);
    }
}