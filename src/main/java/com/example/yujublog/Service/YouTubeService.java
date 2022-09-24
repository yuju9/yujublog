package com.example.yujublog.Service;

import com.example.yujublog.model.YouTube;
import com.example.yujublog.repository.YouTubeProvider;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.model.Thumbnail;
import com.google.api.services.youtube.model.Video;
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
    private static com.google.api.services.youtube.YouTube youtube;

    private static void prettyPrint(Iterator<Video> iteratorSearchResults, YouTube youTube) {

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



                List<YouTube> youtubeList = new ArrayList<>();

                YouTube youTube1 = YouTube.builder()
                        .title(singleVideo.getSnippet().getTitle())
                        .thumbnailPath(thumbnail.getUrl())
                        .videoId(String.valueOf(singleVideo.getId()))
                        .build();

                youtubeList.add(youTube1);

            }
        }
    }


    @Override
    public YouTube get() {
        YouTube youTube = new YouTube();

        try {
            youtube = new com.google.api.services.youtube.YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
                public void initialize(HttpRequest request) throws IOException {
                }
            }).setApplicationName("youtube-video-duration-get").build();


            com.google.api.services.youtube.YouTube.Videos.List videos = youtube.videos().list("id,snippet,contentDetails");
            videos.setKey("AIzaSyATwanBiKb1_Rz7kKgmnKC1IAQWXxW9QyU");
            videos.setId("gFZfwWZV074");
            videos.setMaxResults(NUMBER_OF_VIDEOS_RETURNED); //조회 최대 갯수.
            List<Video> videoList = videos.execute().getItems();

            if (videoList != null) {
                prettyPrint(videoList.iterator(), youTube);
            }

        } catch (GoogleJsonResponseException e) {
            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
        } catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return youTube;
    }


//    public static List<YouTube> youTubeInfo() throws Exception {
//
//        List<YouTube> youtubeList = new ArrayList<>();
//
//
//        YouTube youTubeDto1 = YouTube.builder()
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
