package com.hand.stocksystem;

import com.hand.stocksystem.Service.StockService;
import com.hand.stocksystem.Service.StockService01;
import com.hand.stocksystem.dto.JdbcUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class StockTest {
    @Autowired
    private static StockService01 stockService;
    public static void main(String[] args){

        JdbcTemplate jdbcTemplate = JdbcUtil.getJdbcTemplate();
        try {
            String sql  = "insert into stock(StockCode,StockName) values(021,'sgf')";
//            stockService.insert("001", "test");
            jdbcTemplate.update(sql);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
