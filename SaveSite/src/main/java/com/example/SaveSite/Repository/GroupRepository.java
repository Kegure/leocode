package com.example.SaveSite.Repository;

import com.example.SaveSite.Entity.Group;
import com.example.SaveSite.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends MongoRepository<Group, String> {

    @Query("{ 'title' : ?0 }")
    Group findByTitle(String title);
}
