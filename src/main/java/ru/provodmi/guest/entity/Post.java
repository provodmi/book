package ru.provodmi.guest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Long id;

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    private String post;
}
