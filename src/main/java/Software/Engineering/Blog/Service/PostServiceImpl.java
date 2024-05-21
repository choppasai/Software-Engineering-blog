package Software.Engineering.Blog.Service;

import Software.Engineering.Blog.DTO.PostDTO;
import Software.Engineering.Blog.Entity.Post;
import Software.Engineering.Blog.Repository.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl {
    final private ModelMapper modelMapper;
    final private PostRepo postRepo;

    public PostServiceImpl(ModelMapper modelMapper, PostRepo postRepo) {
        this.modelMapper = modelMapper;
        this.postRepo = postRepo;
    }

    public void createPost(PostDTO postDTO){
        Post post = modelMapper.map(postDTO, Post.class);
        System.out.println(post.getId()+" "+
                post.getContent());
        postRepo.save(post);
    }
    public List<PostDTO> getAllPost(){
        List<Post> post = postRepo.findAll();
        List<PostDTO> postDTOList = new ArrayList<>();
        for(Post p: post){
            PostDTO postDTO = new PostDTO();
            modelMapper.map(p,postDTO);
            postDTOList.add(postDTO);
        }
        return postDTOList;
    }
}
