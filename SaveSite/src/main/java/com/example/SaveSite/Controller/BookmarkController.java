package com.example.SaveSite.Controller;


import com.example.SaveSite.Entity.Bookmark;
import com.example.SaveSite.Entity.User;
import com.example.SaveSite.Service.BookmarkService;
import com.example.SaveSite.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/SaveSite/bookmark")
public class BookmarkController {

    @Autowired
    BookmarkService bookmarkService;

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> CreateBookmark(@RequestBody Bookmark bookmark) {
        try {
            bookmarkService.save(bookmark.getTitle(), bookmark.getLink(), bookmark.getAttachment(), bookmark.getDescription(), bookmark.getStatus(),null,null,null);
            return new ResponseEntity<>("successfully", HttpStatus.CREATED);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating account: " + e.getMessage());
        }
    }

    @GetMapping("/{title}")
    public ResponseEntity<Optional<Bookmark>> getBookmarkByTitle(@PathVariable String title) {
        Optional<Bookmark> bookmark = Optional.ofNullable(bookmarkService.findUserByTitle(title));
        if (bookmark.isPresent()) {
            return ResponseEntity.ok(bookmark);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{login}")
    public ResponseEntity<List<Bookmark>> getBookmarkByUser(@PathVariable String login) {
        User user = userService.findUserByLogin(login);
        if (user != null) {
            List<Bookmark> bookmarks = bookmarkService.findBookByUser(user.getUser_id());
            if (!bookmarks.isEmpty()) {
                return ResponseEntity.ok(bookmarks);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
