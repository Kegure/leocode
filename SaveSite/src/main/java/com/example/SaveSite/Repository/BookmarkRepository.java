package com.example.SaveSite.Repository;

import com.example.SaveSite.Entity.Bookmark;
import com.example.SaveSite.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookmarkRepository extends MongoRepository<Bookmark, String> {

    @Query("{ 'title' : ?0 }")
    Bookmark findByTitle(String title);

    @Query("{ 'user' : ?0 }")
    List<Bookmark> findByUser(String user);

}
