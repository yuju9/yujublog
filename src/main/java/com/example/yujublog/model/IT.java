package com.example.yujublog.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class IT {
    private String url;
    private String title;
    private String date;
    private String content;
}
