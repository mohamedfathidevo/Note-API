package com.dev.notesystem.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class NoteResponse {
    private String title;
    private String subtitle;
    private String noteContent;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private int user_id;
}
