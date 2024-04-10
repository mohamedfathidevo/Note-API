package com.dev.notesystem;

import com.dev.notesystem.entity.User;
import com.dev.notesystem.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@SpringBootApplication
public class NoteAppBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoteAppBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
//            String email = SecurityContextHolder.getContext().getAuthentication().getName();
//            User user = userRepository.findByEmail("mohamedfathidev").orElseThrow(()-> new UsernameNotFoundException("User not found"));
//            System.out.println(user.getId());
//            System.out.println(user.getEmail());
//            System.out.println(user.getUsername());
//            System.out.println(user.getUsername());
        };
    }

}
