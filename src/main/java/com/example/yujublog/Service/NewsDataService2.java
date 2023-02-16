package com.example.yujublog.Service;

import com.example.yujublog.model.Economy;
import com.example.yujublog.model.IT;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsDataService2 {

    private static String url = "https://news.naver.com/main/list.naver?mode=LS2D&mid=shm&sid1=105&sid2=283";

    public List<IT> crawlingIT() throws Exception {

        List<IT> itList = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();

        Elements elements = doc.select("div.list_body.newsflash_body");

        for (Element el : elements.select("dl")) {

            IT it = IT.builder()
                    .title(el.select("dt").text())
                    .url(el.select("dt").select("a").attr("href"))
                    .date(el.select("dd").select("span.date").text())
                    .content(el.select("dd").select("span.lede").text())
                    .build();

            itList.add(it);
        }


        return itList;

    }

}