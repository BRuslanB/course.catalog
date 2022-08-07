package springboot.course.catalog.mapper;

import springboot.course.catalog.dto.CourseDTO;
import springboot.course.catalog.model.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDTO toDto(Course course);
    Course toEntity(CourseDTO CourseDTO);
    List<CourseDTO> toDtoList(List<Course> coursesList);
}
