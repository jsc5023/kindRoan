package com.example.loan.service;

import com.example.loan.domain.UserAccount;
import com.example.loan.dto.UserAccountDto;
import com.example.loan.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {

    private final UserAccountRepository userAccountRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public Optional<UserAccountDto> searchUser(String username) {
        return userAccountRepository.findById(username)
                .map(UserAccountDto::from);
    }

    public UserAccountDto saveUser(String userId, String userPassword, String email, String nickname, String phoneNumber, LocalDateTime birth_date, char gender) {
        return UserAccountDto.from(
                userAccountRepository.save(UserAccount.of(userId, userPassword, email, nickname, phoneNumber, birth_date, gender))
        );
    }
}
