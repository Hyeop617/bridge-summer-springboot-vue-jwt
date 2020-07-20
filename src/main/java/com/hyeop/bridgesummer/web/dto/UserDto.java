package com.hyeop.bridgesummer.web.dto;

import com.hyeop.bridgesummer.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {
    private String id;
    private String password;
    private String nickname;
    private String email;

    public User toEntity(){
        return User.builder()
                .id(id)
                .password(password)
                .nickname(nickname)
                .email(email)
                .build();
    }
}
