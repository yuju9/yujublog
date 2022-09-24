package com.example.yujublog.Controller;

import com.example.yujublog.Service.YouTubeService;
import com.example.yujublog.model.YouTube;
import com.example.yujublog.repository.YouTubeProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YouTubeController {

    private YouTubeProvider youTubeProvider;

    private YouTube youTube;

    @Autowired
    public YouTubeController(
            final YouTubeProvider youTubeProvider
    ) {
        this.youTubeProvider = youTubeProvider;
    }

//    @GetMapping("youtube")
//    public YouTube Index() {
//        return YouTubeProvider.get();
//    }

//    @GetMapping("/music")
//    public String music(Model model) throws Exception {
//        YouTubeService.getYT();
//        model.addAttribute("youtubeTitle", youTube.getTitle());
//        return "music";
//    }

}
