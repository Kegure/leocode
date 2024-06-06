package com.example.SaveSite.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Tags")
public class Tag{

    @Id
    private String tag_id;

    @Indexed(unique = true)
    private String label;
    private String color;

    @DBRef
    private User user;

    public Tag(String label, String color, User user) {
        this.label = label;
        this.color = color;
        this.user = user;
    }

    public Tag() {
    }

}
