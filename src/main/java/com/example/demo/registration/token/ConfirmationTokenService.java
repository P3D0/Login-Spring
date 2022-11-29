package com.example.demo.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private final  ConfirmationTokenReppository confirmationTokenReppository;

    public void saveConfirmationToken (ConfirmationToken token){
        confirmationTokenReppository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenReppository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmationTokenReppository.updateConfirmedAt(token, LocalDateTime.now());
    }
}
