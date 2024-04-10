package com.dev.notesystem.service;

import com.dev.notesystem.entity.Note;
import com.dev.notesystem.entity.User;
import com.dev.notesystem.model.NoteRequest;
import com.dev.notesystem.model.NoteResponse;
import com.dev.notesystem.repository.NoteRepository;
import com.dev.notesystem.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public Note save(NoteRequest request){

        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User not found"));

        Note noteBuilder = Note.builder()
                .title(request.getTitle())
                .subtitle(request.getSubtitle())
                .noteContent(request.getNoteContent())
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .userId(user.getId())
                .build();
        return noteRepository.save(noteBuilder);
    }

    public List<Note> findAllByUserId(){
        return noteRepository.findAllByUserId(getCurrentUserId());
    }

    public Note findByIdAndUserId(Long id){
        return noteRepository.findByIdAndUserId(id, getCurrentUserId()).orElseThrow(()-> new EntityNotFoundException("note not found"));
    }

    public void deleteAllByUserId(){
        noteRepository.deleteAllByUserId(getCurrentUserId());
    }

    public void deleteByIdAndUserId(Long id){
        noteRepository.deleteByIdAndUserId(id, getCurrentUserId());
    }

    public Long getCurrentUserId(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User not found"));
        return user.getId();
    }

}
