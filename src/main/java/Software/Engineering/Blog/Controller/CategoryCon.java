package Software.Engineering.Blog.Controller;

import Software.Engineering.Blog.DTO.CategoryDTO;
import Software.Engineering.Blog.Model.Category;
import Software.Engineering.Blog.Service.CategoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryCon {
    final private CategoryServiceImpl categoryService;

    public CategoryCon(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDTO categoryDTO){
        Category category = categoryService.addCategory(categoryDTO);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable("id") Integer id) throws Exception {
        CategoryDTO categoryDTO = categoryService.getCategory(id);
        return new ResponseEntity<>(categoryDTO,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategory(){
        List<CategoryDTO> ls = categoryService.getListOfCategory();
        return new ResponseEntity<>(ls,HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable("id") Integer id,
                                                      @RequestBody CategoryDTO categoryDTO){
        CategoryDTO categoryDTO1 = categoryService.updateCategory(id,categoryDTO);
        return new ResponseEntity<>(categoryDTO1,HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteCategory(@PathVariable ("id") Integer id){
        categoryService.deleteCategory(id);
        return new ResponseEntity("deleted",HttpStatus.OK);
    }
}
