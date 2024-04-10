package com.dev.notesystem.service;

import com.dev.notesystem.entity.User;
import com.dev.notesystem.model.AuthenticationRequest;
import com.dev.notesystem.model.AuthenticationResponse;
import com.dev.notesystem.model.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
