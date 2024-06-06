package com.example.SaveSite.Repository;

import com.example.SaveSite.Entity.Note;
import com.example.SaveSite.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {

    @Query("{ 'title' : ?0 }")
    Note findByTitle(String title);
}
