package com.example.SaveSite.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Groups")
public class Group {

    @Id
    private String group_id;

    @Indexed(unique = true)
    private String title;

    private String status;

    @DBRef
    private List<Tag> tag;

    @DBRef
    private User user;

    public Group(String title, String status, List<Tag> tag, User user) {
        this.title = title;
        this.status = status;
        this.tag = tag;
        this.user = user;
    }

    public Group() {
    }
}
