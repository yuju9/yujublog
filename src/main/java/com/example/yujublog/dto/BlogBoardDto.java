package com.example.yujublog.dto;

import com.example.yujublog.model.BlogBoard;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BlogBoardDto {
    private int id;
    private String title;
    private String content;
    private Timestamp createDate;

    public BlogBoard toEntity() {
        BlogBoard blogBoard = BlogBoard.builder()
                .id(id)
                .title(title)
                .content(content)
                .createDate(createDate)
                .build();

        return blogBoard;
    }

    @Builder
    public BlogBoardDto(int id, String title, String content, Timestamp createDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
    }
}
