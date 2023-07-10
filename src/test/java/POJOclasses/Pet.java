package POJOclasses;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Pet {
    private long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

    @Getter
    @Setter
    private static class Category {
        private int id;
        private String name;
    }
    @Getter
    @Setter
    private static class Tag {
        private int id;
        private String name;
    }
}
