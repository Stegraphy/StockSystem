package com.hand.stocksystem.Service;

import com.hand.stocksystem.Entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class StockService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Stock> getStockList(){
        return jdbcTemplate.query("select * from stockinfo", new RowMapper<Stock>() {
            @Override
            public Stock mapRow(ResultSet resultSet, int i) throws SQLException {
                Stock stockk = new Stock();
                stockk.setStockCode(resultSet.getString("StockCode"));
                stockk.setStockName(resultSet.getString("StockName"));
                return stockk;
            }
        });
    }

        public void InsertStockData(String StockCode,String StockName){
             jdbcTemplate.update("insert into stockinfo(StockCode,StockName) values (?,?)",StockCode,StockName);
             return ;
        };

}
