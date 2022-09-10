package com.example.yujublog.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mail {
    private String title;
    private String email;
    private String message;
}