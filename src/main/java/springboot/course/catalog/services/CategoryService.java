package springboot.course.catalog.services;

import springboot.course.catalog.dto.CategoryDTO;
import springboot.course.catalog.mapper.CategoryMapper;
import springboot.course.catalog.model.Category;
import springboot.course.catalog.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    public CategoryDTO getCategory(Long id){
        return categoryMapper.toDto(categoryRepository.findById(id).orElseThrow());
    }

    public List<CategoryDTO> getAllCategories(){
        return categoryMapper.toDtoList(categoryRepository.findAll());
    }
}