package com.hand.stocksystem.Service;


import com.hand.stocksystem.Entity.Stock;
import com.hand.stocksystem.dto.JdbcUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;

public class StockDataInfo {

    public static void main(String[] args){

        JdbcTemplate jdbcTemplate = JdbcUtil.getJdbcTemplate();
        Stock stock = new Stock();
        com.hand.stocksystem.Entity.StockDataInfo stockDataInfo = new com.hand.stocksystem.Entity.StockDataInfo();
//                   http://data.gtimg.cn/flashdata/hushen/daily/09/sh601899.js?visitDstTime=1
//        String url = "http://data.gtimg.cn/flashdata/hushen/daily/"+year+"/"+stock.getStockCode()+".js?visitDstTime=1";
        int year = 456;
//        for(int j = 19;j>0;j--){
//            String year = String.format("%02d",j);
            String url = "http://data.gtimg.cn/flashdata/hushen/daily/"+year +"/"+"sh601899.js?visitDstTime=1";
//        }

        Document doc;
        try {
            doc = Jsoup.connect(url).ignoreContentType(true).get();
//            Elements content = doc.select("html").select("body").select("pre");
            Elements tagElements = doc.getElementsByTag("body");
            String str = tagElements.text();
            String[] tt = str.split("n");
            for (int i = 1;i<tt.length-1;i++){
//                System.out.println(i+":"+tt[i]);
                String[] rr = tt[i].split(" ");
                stockDataInfo.setStockData(rr[1]);
                stockDataInfo.setStockPrice(rr[2]);
                try {
                    String sql  = "insert into stockdata(StockCode,StockData,StockPrice) values(?,?,?)";
//            stockService.insert("001", "test");
                    jdbcTemplate.update(sql,"sh601899",stockDataInfo.getStockData(),stockDataInfo.getStockPrice());
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
//            System.out.println(tagElements.text()+"-_-");
//            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
