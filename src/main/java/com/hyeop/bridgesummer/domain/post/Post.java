package com.hyeop.bridgesummer.domain.post;

import com.hyeop.bridgesummer.domain.Time;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Post extends Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60, nullable = false)
    private String title;

    @Column(length = 200, nullable = false)
    private String contents;

    private String nickname;
}
