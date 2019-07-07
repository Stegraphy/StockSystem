package com.hand.stocksystem.Controller;


import com.hand.stocksystem.Entity.Stock;
import com.hand.stocksystem.Service.StockService;
import com.hand.stocksystem.Service.StockService01;
import com.hand.stocksystem.Service.StockServiceImp;
import com.hand.stocksystem.dto.JdbcUtil;
import jdk.management.resource.internal.TotalResourceContext;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import javax.swing.text.Document;

public class JsoupTest {
    private String url ;
    // 构造方法
    private JsoupTest(String url){
        this.url = url;
    }

    public static void main(String[] args) {
//        int num  = 1;

      /*  StockService01 sk = null;
        if (sk != null) {
            sk.insert("001","test");
        }*/
        String Url[] = new String[15];
        for (int i = 0;i<Url.length;i++){
            int page = i+81;
            Url[i] = "http://vip.stock.finance.sina.com.cn/q/go.php/vIR_CustomSearch/index.phtml?sr_p=-1&rating=&srating=&p="+page;
        }
        //String url = "http://vip.stock.finance.sina.com.cn/q/go.php/vIR_CustomSearch/index.phtml?sr_p=-1&rating=&srating=&p="+num;
/*//        String url;
        if (args.length==1){
            url = args[0];
//            url ="http://money.finance.sina.com.cn/corp/go.php/vMS_MarketHistory/stockid/603366.phtml?year=2012&jidu=3";
        } else {
            System.out.println(" usage: java SoupTest http:// ");
            return;
        }*/
       for (int j = 0;j<Url.length;j++) {
            JsoupTest app = new JsoupTest(Url[j]);
            app.run();
        }

    }

    private static com.hand.stocksystem.Entity.Stock Stock = new Stock();
    private static int table1(Document doc){
         Map<String,String> map = new HashMap<>();
         //找到网页中表格中的行
        Elements trs = doc.select("table").select("tr");
        int count = 0,TotalCount=0;
        //分页获取每一行的列
        for (int i=0; i<=trs.size()-1; i++){
            Elements tds = trs.get(i).select("td");
//            for (int j=0; j<2; j++){
//                String txt = tds.get(j).text();
//            if(i!=0) {
                String txt = tds.get(1).select("a").select("span").attr("id");
                String name = tds.get(1).text();
                Stock.setStockName(name);
//                Pattern pattern = Pattern.compile("/?q=(.*?)&contry");
                Pattern pattern = Pattern.compile("name");
                Matcher matcher = pattern.matcher(txt);
//                System.out.println(txt);
            if(txt.length()>0){
                String[] sout = txt.split("_");
//                map.put(sout[1].toString(),name);
                Stock.setStockCode(sout[1].toString());
//                System.out.print(Stock.getStockCode()+":");
//                System.out.println(Stock.getStockName());
                JdbcTemplate jdbcTemplate = JdbcUtil.getJdbcTemplate();
                try {
                    String sql  = "insert into stocktest(StockCode,StockName) values(?,?)";
//            stockService.insert("001", "test");
                    jdbcTemplate.update(sql,Stock.getStockCode(),Stock.getStockName());
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }else{
                System.out.println("----");
            }


                while(matcher.find()){
                   /* if(matcher.group(1).length()==0){
//                        System.out.println("First");
                    }else{
                        String tt = matcher.group(1);
                        String ss = tt+"sed";
                        System.out.println(ss);
                    }*/

//                    System.out.print("?"+matcher.group(1)+"---");
                }
//                Stock.setStockCode(txt);

//                Stock.setStockName(name);
//                System.out.print(txt+" * ");
//                map.put(txt,name);
//                System.out.print(Stock.getStockCode()+" ");
//                System.out.print(Stock.getStockName());
//                System.out.println(map.get(txt));
//                count++;
//            }
//            }
            for (Object o : map.entrySet()) {
                Map.Entry entry = (Map.Entry) o;
                Object key = entry.getKey();
                Object value = entry.getValue();
//                System.out.println(key + ":" + value);

            }
        }
//        System.out.println(TotalCount);
        return count;
    }

    // 运行过程
    private void run(){
        Document doc;
        int rows;
        try {
            doc = (Document) Jsoup.connect(url).get();
            // Page: 1
            rows = table1(doc);
//            System.out.println(" rows: "+rows);
//            System.out.println("Finish");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
