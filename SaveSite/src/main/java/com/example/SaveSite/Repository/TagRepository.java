package com.example.SaveSite.Repository;

import com.example.SaveSite.Entity.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends MongoRepository<Tag, String> {

    @Query("{ 'label' : ?0 }")
    Tag findByLabel(String label);
}
