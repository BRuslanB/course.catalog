package springboot.course.catalog.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import springboot.course.catalog.dto.CourseDTO;
import springboot.course.catalog.model.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mappings({
            @Mapping(target = "priceValue", source = "price"),
            @Mapping(target = "ratingValue", source = "rating")
    })
    CourseDTO toDto(Course course);

    @Mappings({
            @Mapping(target = "price", source = "priceValue"),
            @Mapping(target = "rating", source = "ratingValue")
    })    Course toEntity(CourseDTO CourseDTO);

    List<CourseDTO> toDtoList(List<Course> coursesList);
}
