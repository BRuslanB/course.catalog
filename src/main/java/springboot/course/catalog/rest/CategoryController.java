package springboot.course.catalog.rest;

import springboot.course.catalog.dto.CategoryDTO;
import springboot.course.catalog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/categories")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        return new ResponseEntity<>(categoryService.getAllCategoriesDTO(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CategoryDTO> getCourse(@PathVariable(name="id") Long id){
        return new ResponseEntity<>(categoryService.getCategoryDTO(id), HttpStatus.OK);
    }
}