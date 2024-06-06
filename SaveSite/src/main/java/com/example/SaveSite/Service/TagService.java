package com.example.SaveSite.Service;

import com.example.SaveSite.Entity.Tag;
import com.example.SaveSite.Entity.User;
import com.example.SaveSite.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository repository;

    public void save(String label, String color, User user) {
        try {
        Tag tag = new Tag(label, color, user);
        this.repository.save(tag);
        } catch (DuplicateKeyException e) {
            throw new IllegalArgumentException("Label ja definida para outra tag");
        } catch (Exception e) {
            throw new RuntimeException("Error saving user: " + e.getMessage());
        }
    }

    public Tag findUserByLabel(String Label) {
        return repository.findByLabel(Label);
    }

    public Tag updateTag(String tag_id, String label, String color) {
        Optional<Tag> userOptional = repository.findById(tag_id);
        if (userOptional.isPresent()) {
            Tag tag = userOptional.get();
            if(!Objects.equals(label, "")) {
                tag.setTag_id(label);
            }
            if(!Objects.equals(color, "")) {
                tag.setColor(color);
            }
            return repository.save(tag);
        } else {
            throw new RuntimeException("tag not found.");
        }
    }

    public void deleteTagById(String tag_id) {
        repository.deleteById(tag_id);
    }
}