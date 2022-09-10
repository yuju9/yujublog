package com.example.yujublog.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class Economy {
    private String url;
    private String title;
    private String date;
    private String content;
}
