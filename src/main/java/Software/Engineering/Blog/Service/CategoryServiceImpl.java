package Software.Engineering.Blog.Service;

import Software.Engineering.Blog.DTO.CategoryDTO;
import Software.Engineering.Blog.Entity.Category;
import Software.Engineering.Blog.Repository.CategoryRepo;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryServiceImpl {
    final private CategoryRepo categoryRepo;
    final private ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepo categoryRepo, ModelMapper modelMapper) {
        this.categoryRepo = categoryRepo;
        this.modelMapper = modelMapper;
    }


    public Category addCategory(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        categoryRepo.save(category);
        return category;
    }
    public CategoryDTO getCategory(Integer id) throws Exception {
        CategoryDTO categoryDTO = new CategoryDTO();
        Category category = categoryRepo.findById(id).orElseThrow(()-> new EntityNotFoundException(String.valueOf(id)));
//        if(c.isPresent()){
//            Category ca = c.get();
//            categoryDTO.setName(ca.getName());
//        }
//        else{
//            throw new Exception("fa");
//        }
//        categoryDTO.setName(category.getName());
//        categoryDTO.setDescription(category.getDescription());
        return modelMapper.map(category,CategoryDTO.class);
    }
    public List<CategoryDTO> getListOfCategory(){
        List<Category> lc = categoryRepo.findAll();
        List<CategoryDTO> ld = new ArrayList<>();
        for(Category c:lc){
            CategoryDTO categoryDTO = modelMapper.map(c,CategoryDTO.class);
            ld.add(categoryDTO);
        }
        return ld;
    }
    public CategoryDTO updateCategory(Integer id,CategoryDTO categoryDTO){
        Category category = categoryRepo.findById(id).orElseThrow(()-> new EntityNotFoundException(String.valueOf(id)));
        category.setId(id);
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        Category category1 = categoryRepo.save(category);
        return modelMapper.map(category1,CategoryDTO.class);
    }

    public void deleteCategory(Integer id){
        Category category = categoryRepo.findById(id).orElseThrow(()->new EntityNotFoundException(String.valueOf(id)));
        categoryRepo.delete(category);
    }
}
