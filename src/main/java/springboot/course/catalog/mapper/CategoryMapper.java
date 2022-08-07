package springboot.course.catalog.mapper;

import springboot.course.catalog.dto.CategoryDTO;
import springboot.course.catalog.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDto(Category category);
    Category toEntity(CategoryDTO categoryDTO);
    List<CategoryDTO> toDtoList(List<Category> categoriesList);
}
