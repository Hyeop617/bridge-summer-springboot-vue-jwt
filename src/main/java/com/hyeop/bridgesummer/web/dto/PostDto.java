package com.hyeop.bridgesummer.web.dto;


import com.hyeop.bridgesummer.domain.post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class PostDto {
    private String title;
    private String contents;
    private String nickname;

    public Post toEntitiy(){
        return Post.builder()
                .title(title)
                .contents(contents)
                .nickname(nickname)
                .build();
    }
}
