package com.dev.notesystem.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NoteRequest {
    private String title;
    private String subtitle;
    private String noteContent;
}
