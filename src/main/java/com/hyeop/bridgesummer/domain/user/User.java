package com.hyeop.bridgesummer.domain.user;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Column(unique = true)
    private String id;
    private String password;
    private String nickname;
    private String email;

    @Transient
    private Collection<? extends GrantedAuthority> authorities;
    @Transient
    private boolean accountNonExpired = true;
    @Transient
    private boolean accountNonLocked = true;
    @Transient
    private boolean credentialsNonExpired = true;
    @Transient
    private boolean enabled = true;

    @Builder
    public User(Long uid, String id, String password, String nickname, String email) {
        this.uid = uid;
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }


}
