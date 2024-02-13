package alessiapalmieri.U5W2D2.Entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BlogPost {
    private long id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private int readingTime;
}
