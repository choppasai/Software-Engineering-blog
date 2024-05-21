package Software.Engineering.Blog.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.apache.logging.log4j.message.Message;
import org.aspectj.bridge.IMessage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private String URL;
    @NotEmpty(message = "Content field should not be empty")
    private String content;
    @NotEmpty(message = "Title field should not be empty")
    private String title;
    @NotEmpty(message = "Description field should not be empty")
    private String description;
    private LocalDate createdOn;
    private LocalDate updatedOn;

}
