package com.example.SaveSite.Service;

import com.example.SaveSite.Entity.Bookmark;
import com.example.SaveSite.Entity.Group;
import com.example.SaveSite.Entity.Tag;
import com.example.SaveSite.Entity.User;
import com.example.SaveSite.Repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookmarkService {

    @Autowired
    private BookmarkRepository repository;

    public void save(String title, String link, String attachment, String description, String status, List<Tag> tags, Group group, User user) {
        try {
        Bookmark bookmark = new Bookmark(title, link,attachment, description, status, tags, group, user);
        this.repository.save(bookmark);
        } catch (DuplicateKeyException e) {
            throw new IllegalArgumentException("Titulo ja definido a outro Bookmark");
        } catch (Exception e) {
            throw new RuntimeException("Error saving user: " + e.getMessage());
        }
    }

    public Bookmark findUserByTitle(String title) {
        return repository.findByTitle(title);
    }

    public Bookmark updateBookmark(String userId, String link, String attachment, String description, String status) {
        Optional<Bookmark> bookmarkOptional = repository.findById(userId);
        if (bookmarkOptional.isPresent()) {
            Bookmark bookmark = bookmarkOptional.get();
            if(!Objects.equals(link, "")) {
                bookmark.setLink(link);
            }
            if(!Objects.equals(attachment, "")) {
                bookmark.setAttachment(attachment);
            }
            if(!Objects.equals(description, "")) {
                bookmark.setDescription(attachment);
            }
            if(!Objects.equals(status, "")) {
                bookmark.setStatus(status);
            }
            return repository.save(bookmark);
        } else {
            throw new RuntimeException("User not found.");
        }
    }

    public void deleteBookmarkById(String bookmark_Id) {
        repository.deleteById(bookmark_Id);
    }

    public List<Bookmark> findBookByUser(String user) {
        return repository.findByUser(user);
    }
}
