package springboot.course.catalog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDTO {
    private Long id;
    private String name;
    private String description;
    private double priceValue;
    private int ratingValue;
    private CategoryDTO category;
}
