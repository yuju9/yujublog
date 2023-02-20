package com.example.yujublog.Controller;

import com.example.yujublog.Service.NewsDataService2;
import com.example.yujublog.model.Economy;
import com.example.yujublog.Service.NewsDataService;
import com.example.yujublog.model.IT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final NewsDataService newsDataService;
    private final NewsDataService2 newsDataService2;


    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/board")
    public String board2() {
        return "board";
    }


    @GetMapping("/news")
    public String news(Model model) throws Exception {
        List<Economy> economyList = newsDataService.crawling();
        List<IT> itList = newsDataService2.crawlingIT();
        model.addAttribute("Economy", economyList);
        model.addAttribute("It", itList);
        return "news";
    }

    @GetMapping("/music")
    public String music() {
        return "music";
    }

    @GetMapping("/ask")
    public String ask() {
        return "ask";
    }

    @GetMapping("/join")
    public String joinForm() {
        return "join";
    }

    @GetMapping("/login")
    public String login() {return "loginForm";}


//    @GetMapping("/login")
//    public String login(){
//        return "login";
//    }


}
