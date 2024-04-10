package com.dev.notesystem.repository;

import com.dev.notesystem.entity.Note;
import com.dev.notesystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByUserId(Long userId);
    @Modifying
    @Query("delete from Note n where n.userId = :userId")
    void deleteAllByUserId(Long userId);
    Optional<Note> findByIdAndUserId(Long id, Long userId);
    @Modifying
    @Query("delete from Note n where n.id = :id and n.userId = :userId")
    void deleteByIdAndUserId(Long id, Long userId);
}
