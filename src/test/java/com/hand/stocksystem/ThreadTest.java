package com.hand.stocksystem;

import com.hand.stocksystem.Entity.StockDataInfo;
import com.hand.stocksystem.dto.JdbcUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public abstract class ThreadTest implements Runnable{
    private static int incrementId = 1;

    public synchronized static int getincrementId() {
        return incrementId++;
    }

    public void run() {


        int id = 0;
        while ((id = getincrementId()) <= 3790) {

            try {
                String sql  = "insert into thread(StockCode,StockName) values(?,?)";
//            stockService.insert("001", "test");
//            for(int i = 0;i<3790;i++){
//                jdbcTemplate.update(sql,id,"dh");
//            }

                JdbcTemplate jdbcTemplate = JdbcUtil.getJdbcTemplate();
                String selectsql = "select StockCode from stock";
                jdbcTemplate.query(selectsql, new RowMapper<StockDataInfo>() {
                    @Override
                    public StockDataInfo mapRow(ResultSet resultSet, int i) throws SQLException {
                        StockDataInfo stockDataInfo1 = new StockDataInfo();
                        stockDataInfo1.setStockid(resultSet.getInt(("id")));
                        Map<Integer,String> map = new HashMap<>();
                        map.put(stockDataInfo1.getStockid(),stockDataInfo1.getStockCode());
                        stockDataInfo1.setStockCode(resultSet.getString("StockCode"));
//                        System.out.println(stockDataInfo1.getStockCode());
                        System.out.println("");
                        return stockDataInfo1;
                    }
                });

            } catch (Exception e) {

                e.printStackTrace();
            }
//            System.out.println("插入数据主键:" + id + " 当前线程" + Thread.currentThread().getName() + " ");
        }
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            Thread thread = new Thread(new ThreadTest() {
                @Override
                public void run() {
                    super.run();
                }
            });
            thread.setName("线程" + i);
            thread.start();
        }
    }
}
