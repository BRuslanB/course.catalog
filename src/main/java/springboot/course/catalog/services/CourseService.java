package springboot.course.catalog.services;

import springboot.course.catalog.dto.CourseDTO;
import springboot.course.catalog.mapper.CourseMapper;
import springboot.course.catalog.model.Course;
import springboot.course.catalog.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public Course addCourse(Course course){
        return courseRepository.save(course);
    }

    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }

    public void deleteCourse(Course course){
        courseRepository.delete(course);
    }

    public Course getCourse(Long id){
        return courseRepository.findById(id).orElseThrow();
    }
    public CourseDTO getCourseDTO(Long id){
        return courseMapper.toDto(courseRepository.findById(id).orElseThrow());
    }

    public List<CourseDTO> getAllCoursesDTO(){
        return courseMapper.toDtoList(courseRepository.findAll());
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }
}