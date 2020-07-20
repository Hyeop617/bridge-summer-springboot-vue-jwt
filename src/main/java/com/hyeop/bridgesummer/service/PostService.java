package com.hyeop.bridgesummer.service;

import com.hyeop.bridgesummer.domain.post.PostRepository;
import com.hyeop.bridgesummer.domain.user.User;
import com.hyeop.bridgesummer.domain.user.UserRepository;
import com.hyeop.bridgesummer.web.dto.PostDto;
import com.hyeop.bridgesummer.web.dto.UserDto;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Long save(PostDto postDto){
        return postRepository.save(postDto.toEntitiy()).getId();
    }

}
