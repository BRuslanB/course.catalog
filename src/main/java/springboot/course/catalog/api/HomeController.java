package springboot.course.catalog.api;

import springboot.course.catalog.dto.CategoryDTO;
import springboot.course.catalog.dto.CourseDTO;
import springboot.course.catalog.services.CategoryService;
import springboot.course.catalog.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final CategoryService categoryService;
    private final CourseService courseService;

    @GetMapping("/")
    public String indexPage(Model model) {

        return "index";
    }

    @GetMapping("/categorydetails/{categoryId}")
    public String categoryDetailsPage(@PathVariable(name="categoryId") Long categoryId,
                              Model model){
        CategoryDTO oneCategory = categoryService.getCategory(categoryId);
        model.addAttribute("oneCategory", oneCategory);
        return "categorydetails";
    }

    @GetMapping("/coursedetails/{courseId}")
    public String courseDetailsPage(@PathVariable(name="courseId") Long courseId,
                              Model model){
        CourseDTO oneCourse = courseService.getCourse(courseId);
        model.addAttribute("oneCourse", oneCourse);
        return "coursedetails";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/categories")
    public String categoriesPage(Model model) {

        List<CategoryDTO> allCategories= categoryService.getAllCategories();
        model.addAttribute("allCategories", allCategories);

        return "categories";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/courses")
    public String coursesPage(Model model) {

        List<CategoryDTO> allCategories= categoryService.getAllCategories();
        model.addAttribute("allCategories", allCategories);

        List<CourseDTO> allCourses= courseService.getAllCourses();
        model.addAttribute("allCourses", allCourses);

        return "courses";
    }
}