package com.example.loan.security;

import com.example.loan.domain.UserAccount;
import com.example.loan.dto.UserAccountDto;
import com.example.loan.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserAccountService {
    private final UserAccountRepository userAccountRepository;

    @Transactional(readOnly = true)
    public Optional<UserAccountDto> searchUser(String username) {
        return userAccountRepository.findById(username)
                .map(UserAccountDto::from);
    }

    public UserAccountDto saveUser(String userId, String password, String email, String nickname, String phoneNumber, LocalDateTime birth_date, char gender) {
        return UserAccountDto.from(
                userAccountRepository.save(UserAccount.of(userId, password, email, nickname, phoneNumber, birth_date, gender))
        );
    }
}
