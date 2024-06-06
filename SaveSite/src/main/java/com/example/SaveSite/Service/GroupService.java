package com.example.SaveSite.Service;

import com.example.SaveSite.Entity.Group;
import com.example.SaveSite.Entity.Tag;
import com.example.SaveSite.Entity.User;
import com.example.SaveSite.Repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    private GroupRepository repository;

    public void save(String title, String status, List<Tag> tag, User user) {
        try {
        Group group = new Group(title, status, tag, user);
        this.repository.save(group);
        } catch (DuplicateKeyException e) {
            throw new IllegalArgumentException("Titulo ja definido a outro Grupo");
        } catch (Exception e) {
            throw new RuntimeException("Error saving user: " + e.getMessage());
        }
    }

    public Group findUserByTitle(String title) {
        return repository.findByTitle(title);
    }

    public Group updateUser(String userId, String status) {
        Optional<Group> groupOptional = repository.findById(userId);
        if (groupOptional.isPresent()) {
            Group group = groupOptional.get();
            if(!Objects.equals(status, "")) {
                group.setStatus(status);
            }
            return repository.save(group);
        } else {
            throw new RuntimeException("User not found.");
        }
    }

    public void deleteGroupById(String Group_Id) {
        repository.deleteById(Group_Id);
    }
}
