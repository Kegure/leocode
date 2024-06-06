package com.example.SaveSite.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Bookmarks")
public class Bookmark {

    @Id
    private String bookmark_id;

    @Indexed(unique = true)
    private String title;

    private String link;
    private String attachment;
    private String description;
    private String status;

    @DBRef
    private List<Tag> tags;

    @DBRef
    private Group group;

    @DBRef
    private User user;

    public Bookmark(String title, String link, String attachment, String description, String status, List<Tag> tags, Group group, User user) {
        this.title = title;
        this.link = link;
        this.attachment = attachment;
        this.description = description;
        this.status = status;
        this.tags = tags;
        this.group = group;
        this.user = user;
    }

    public Bookmark() {
    }
}
