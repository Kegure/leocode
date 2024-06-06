package com.example.SaveSite.Entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Notes")
public class Note{

    @Id
    private String note_id;

    @Indexed(unique = true)
    private String title;

    private String parent_id;

    private String content;

    private String creation_date;

    private String last_modfied;

    @DBRef
    private User user;

    public Note(String parent_id, String title, String content, String creation_date, String last_modfied, User user) {
        this.parent_id = parent_id;
        this.title = title;
        this.content = content;
        this.creation_date = creation_date;
        this.last_modfied = last_modfied;
        this.user = user;
    }

    public Note() {
    }
}
