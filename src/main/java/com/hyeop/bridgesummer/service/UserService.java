package com.hyeop.bridgesummer.service;

import com.hyeop.bridgesummer.domain.user.User;
import com.hyeop.bridgesummer.domain.user.UserRepository;
import com.hyeop.bridgesummer.web.dto.UserDto;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity signup(UserDto userDto) {
        if(userRepository.findById(userDto.getId()).isPresent()){
            return new ResponseEntity("EXIST_ID", HttpStatus.OK);
        }else if(userRepository.findById(userDto.getNickname()).isPresent()){
            return new ResponseEntity("EXIST_NICKNAME",HttpStatus.OK);
        }
        User user = User.builder()
                .id(userDto.getId())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickname())
                .email(userDto.getEmail())
                .build();
        userRepository.save(user);
        return new ResponseEntity("SUCCESS",HttpStatus.OK);
    }

    public ResponseEntity login(UserDto userDto) {
        Optional<User> user = userRepository.findById(userDto.getId());
        if (user.isPresent()) {
            if(passwordEncoder.matches(userDto.getPassword(),user.get().getPassword())){
                return new ResponseEntity("SUCCESS", HttpStatus.OK);
            }else{
                return new ResponseEntity("ERR_PW", HttpStatus.OK);
            }
        }
        return new ResponseEntity("NOT_FOUND", HttpStatus.OK);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(() -> new IllegalArgumentException("User Not Found"));
        return null;
    }
}
