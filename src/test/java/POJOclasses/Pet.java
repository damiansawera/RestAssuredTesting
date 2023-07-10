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

    private class Category {
        private int id;
        private String name;
    }

    private class Tag {
        private int id;
        private String name;
    }
}
