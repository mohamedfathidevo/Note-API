package com.dev.notesystem.controller;


import com.dev.notesystem.entity.Note;
import com.dev.notesystem.entity.User;
import com.dev.notesystem.model.NoteRequest;
import com.dev.notesystem.repository.UserRepository;
import com.dev.notesystem.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/note")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    public ResponseEntity<Note> save(@RequestBody NoteRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(noteService.save(request));
    }

    @GetMapping
    public ResponseEntity<List<Note>> allNotes(){
        return ResponseEntity.ok(noteService.findAllByUserId());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> findById(@PathVariable Long id) {
        return ResponseEntity.ok(noteService.findByIdAndUserId(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll(){
        noteService.deleteAllByUserId();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        noteService.deleteByIdAndUserId(id);
        return ResponseEntity.noContent().build();
    }
}
