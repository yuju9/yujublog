package com.example.yujublog.Service;

import com.example.yujublog.model.Economy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsDataService {

    private static String url = "https://news.naver.com/main/list.naver?mode=LS2D&mid=shm&sid1=101&sid2=259";

    public List<Economy> crawling() throws Exception {

        List<Economy> economyList = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();

        Elements elements = doc.select("div.list_body.newsflash_body");

        for (Element el : elements.select("dl")) {

            Economy economy = Economy.builder()
                    .title(el.select("dt").text())
                    .url(el.select("dt").select("a").attr("href"))
                    .date(el.select("dd").select("span.date").text())
                    .content(el.select("dd").select("span.lede").text())
                    .build();

            economyList.add(economy);
        }


        return economyList;

    }

}