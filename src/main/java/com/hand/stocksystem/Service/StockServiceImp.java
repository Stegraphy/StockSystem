package com.hand.stocksystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


@Repository
public class StockServiceImp implements StockService01 {

    @Resource
    private JdbcTemplate jdbcTemplate;
    @Override
    public int insert(String code, String name){
        String sql = "insert into stockinfo(StockCode,StockName) values (?,?)";
         return this.jdbcTemplate.update(sql,code,name);

    }
}
