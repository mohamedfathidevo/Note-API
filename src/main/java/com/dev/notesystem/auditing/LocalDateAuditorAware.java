package com.dev.notesystem.auditing;

import org.springframework.data.domain.AuditorAware;

import java.time.LocalDateTime;
import java.util.Optional;

public class LocalDateAuditorAware implements AuditorAware<LocalDateTime> {
    @Override
    public Optional<LocalDateTime> getCurrentAuditor() {
        return Optional.of(LocalDateTime.now());
    }
}
