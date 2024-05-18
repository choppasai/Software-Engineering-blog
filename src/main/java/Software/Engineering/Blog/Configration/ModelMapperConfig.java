package Software.Engineering.Blog.Configration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper ModelMapper(){
        return new ModelMapper();
    }
}
