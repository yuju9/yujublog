package com.example.yujublog.Controller;

import com.example.yujublog.dto.YouTubeDto;
import com.example.yujublog.repository.YouTubeProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YouTubeController {

    private YouTubeProvider youTubeProvider;

    private YouTubeDto youTubeDto;

    @Autowired
    public YouTubeController(
            final YouTubeProvider youTubeProvider
    ) {
        this.youTubeProvider = youTubeProvider;
    }

    @GetMapping("youtube")
    public YouTubeDto Index() {
        return youTubeProvider.get();
    }

//    @GetMapping("/music")
//    public String music(Model model) throws Exception {
//        model.addAttribute("youtubeTitle", youTubeDto.getTitle());
//        return "music";
//    }

}
