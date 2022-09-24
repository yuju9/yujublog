package com.example.yujublog.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class YouTube {

    private String title;
    private String thumbnailPath;
    private String videoId;

    @Builder(toBuilder = true)
    public YouTube(String title, String thumbnailPath, String videoId) {
        this.title = title;
        this.thumbnailPath = thumbnailPath;
        this.videoId = videoId;
    }
}
