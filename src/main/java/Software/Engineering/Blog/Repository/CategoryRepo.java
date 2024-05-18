package Software.Engineering.Blog.Repository;

import Software.Engineering.Blog.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

}
