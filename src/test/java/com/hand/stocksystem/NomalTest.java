package com.hand.stocksystem;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class NomalTest {
    public static void main(String[] args) {
        for (int j = 19; j > 0; j--) {
            String year = String.format("%02d", j);
            String url = "http://data.gtimg.cn/flashdata/hushen/daily/" + year + "/" + "sh601899.js?visitDstTime=1";
            Document doc;
            try {
                doc = Jsoup.connect(url).ignoreContentType(true).get();
                Elements tagElements = doc.getElementsByTag("body");
                String str = tagElements.text();
                String[] tt = str.split("n");
                for (int i = 1; i < tt.length - 1; i++) {
//                System.out.println(i+":"+tt[i]);
                    String[] rr = tt[i].split(" ");
                    System.out.print(rr[1] + " ");
                    System.out.println(rr[2]);
                }
            } catch (IOException e) {
                System.out.println("最新数据截止到" + year + "年");
                j = 0;
            }
        }
    }
}
