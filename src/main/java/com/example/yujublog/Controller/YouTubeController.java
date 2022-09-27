package com.example.yujublog.Controller;

import com.example.yujublog.Service.YouTubeService;
import com.example.yujublog.model.Economy;
import com.example.yujublog.model.YouTube;
import com.example.yujublog.repository.YouTubeProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class YouTubeController {

    private YouTubeProvider youTubeProvider;

    private YouTube youTube;

    @Autowired
    private YouTubeService youTubeService;

//    @Autowired
//    public YouTubeController(
//            final YouTubeProvider youTubeProvider
//    ) {
//        this.youTubeProvider = youTubeProvider;
//    }

//    @GetMapping("youtube")
//    public YouTube Index() {
//        return YouTubeProvider.get();
//    }

//    @GetMapping("/music")
//    public String music(Model model) throws Exception {
//        youTubeService.get();
//        model.addAttribute("youtubeTitle", youTube.getTitle());
//        return "music";
//    }

}
