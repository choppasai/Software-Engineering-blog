package Software.Engineering.Blog.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String URL;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    private String description;
    private LocalDate createdOn;
    private LocalDate updatedOn;
}
