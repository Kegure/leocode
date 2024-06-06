package com.example.SaveSite.Service;

import com.example.SaveSite.Entity.Note;
import com.example.SaveSite.Entity.User;
import com.example.SaveSite.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository repository;

    public void save(String parent_id, String title, String content, User user) {
        try {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        Note note = new Note(parent_id,title, content, dateFormat.format(date), dateFormat.format(date),user);
        this.repository.save(note);
        } catch (DuplicateKeyException e) {
            throw new IllegalArgumentException("Titulo ja deinido a outra anotação");
        } catch (Exception e) {
            throw new RuntimeException("Error saving user: " + e.getMessage());
        }
    }

    public Note findUserByLogin(String title) {
        return repository.findByTitle(title);
    }

    public Note updateNote(String note_Id, String title, String content) {
        Optional<Note> userOptional = repository.findById(note_Id);
        if (userOptional.isPresent()) {
            Note note = userOptional.get();
            if(!Objects.equals(title, "")) {
                note.setTitle(title);
            }
            if(!Objects.equals(content, "")) {
                note.setContent(content);
            }
            return repository.save(note);
        } else {
            throw new RuntimeException("User not found.");
        }
    }

    public void deleteNoteById(String note_id) {
        repository.deleteById(note_id);
    }
}
