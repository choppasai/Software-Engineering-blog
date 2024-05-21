package Software.Engineering.Blog.Controller;

import Software.Engineering.Blog.DTO.PostDTO;
import Software.Engineering.Blog.Service.PostServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
//@RequestMapping("/post")
public class PostController {
    final private PostServiceImpl postServiceImp;

    public PostController(PostServiceImpl postServiceImp) {
        this.postServiceImp = postServiceImp;
    }
    @GetMapping("admin/posts")
    public String getAllPost(Model model){
        List<PostDTO> list = postServiceImp.getAllPost();
        model.addAttribute("posts",list);
        return "admin/posts";
    }
    @GetMapping("/admin/posts/new post")
    public String postForm(Model model){
        PostDTO postDTO = new PostDTO();
        model.addAttribute("post",postDTO);
        return "admin/create";
    }
    @PostMapping("admin/creation")
    public String createForm(@Valid @ModelAttribute("post") PostDTO postDTO, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("post",postDTO);
            return "admin/create";
        }
        postDTO.setURL(getURL(postDTO.getTitle()));
        postDTO.setCreatedOn(LocalDate.now());
        postServiceImp.createPost(postDTO);
        return "redirect:/admin/posts";
    }
    public String getURL(String title){
        String str = title.trim().toLowerCase().replaceAll("\\s","-");
        str = str.replaceAll("[^a-zA-Z0-9]","-");
        return str;
    }
}
