package com.example.yujublog.dto;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class YouTubeDto {

    private String title;
    private String thumbnailPath;
    private String videoId;

    @Builder(toBuilder = true)
    public YouTubeDto(String title, String thumbnailPath, String videoId) {
        this.title = title;
        this.thumbnailPath = thumbnailPath;
        this.videoId = videoId;
    }
}
