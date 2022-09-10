package com.example.yujublog.Service;

import com.example.yujublog.dto.YouTubeDto;
import com.example.yujublog.model.Economy;
import com.example.yujublog.repository.YouTubeProvider;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;
import com.google.api.services.youtube.model.Video;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class YouTubeService implements YouTubeProvider {
    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static final JsonFactory JSON_FACTORY = new JacksonFactory();
    private static final long NUMBER_OF_VIDEOS_RETURNED = 1;
    private static YouTube youtube;

    private static void prettyPrint(Iterator<Video> iteratorSearchResults, YouTubeDto youTubeDto) {

        System.out.println("\n=============================================================");
        System.out.println("=============================================================\n");

        if (!iteratorSearchResults.hasNext()) {
            System.out.println(" There aren't any results for your query.");
        }

        while (iteratorSearchResults.hasNext()) {

            Video singleVideo = iteratorSearchResults.next();

            if (singleVideo.getKind().equals("youtube#video")) {
                Thumbnail thumbnail = (Thumbnail) singleVideo.getSnippet().getThumbnails().get("default");

                System.out.println(" Video Id" + singleVideo.getId());
                System.out.println(" Title: " + singleVideo.getSnippet().getTitle());
                System.out.println(" Thumbnail: " + thumbnail.getUrl());
                System.out.println("\n-------------------------------------------------------------\n");


                List<YouTubeDto> youtubeList = new ArrayList<>();

                YouTubeDto youTubeDto1 = YouTubeDto.builder()
                        .title(singleVideo.getSnippet().getTitle())
                        .thumbnailPath(thumbnail.getUrl())
                        .videoId(String.valueOf(singleVideo.getId()))
                        .build();

                youtubeList.add(youTubeDto1);


                youTubeDto.setThumbnailPath(thumbnail.getUrl());
                youTubeDto.setTitle(singleVideo.getSnippet().getTitle());
                youTubeDto.setVideoId(String.valueOf(singleVideo.getId()));
            }
        }
    }

    @Override
    public YouTubeDto get() {
        YouTubeDto youTubeDto = new YouTubeDto();

        try {
            youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
                public void initialize(HttpRequest request) throws IOException {
                }
            }).setApplicationName("youtube-video-duration-get").build();

            //내가 원하는 정보 지정할 수 있어요. 공식 API문서를 참고해주세요.
            YouTube.Videos.List videos = youtube.videos().list("id,snippet,contentDetails");
            videos.setKey("AIzaSyATwanBiKb1_Rz7kKgmnKC1IAQWXxW9QyU");
            videos.setId("gFZfwWZV074");
            videos.setMaxResults(NUMBER_OF_VIDEOS_RETURNED); //조회 최대 갯수.
            List<Video> videoList = videos.execute().getItems();

            if (videoList != null) {
                prettyPrint(videoList.iterator(), youTubeDto);
            }

        } catch (GoogleJsonResponseException e) {
            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
        } catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return youTubeDto;
    }

//    public static List<YouTubeDto> youTubeInfo() throws Exception {
//
//        List<YouTubeDto> youtubeList = new ArrayList<>();
//
//
//        YouTubeDto youTubeDto1 = YouTubeDto.builder()
//                .title(singleVideo.getSnippet().getTitle())
//                .thumbnailPath(thumbnail.getUrl())
//                .videoId(String.valueOf(singleVideo.getId()))
//                .build();
//
//        youtubeList.add(youTubeDto1);
//
//
//        return youtubeList;
//
//    }
}
