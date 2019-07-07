package com.hand.stocksystem.Controller;

import com.hand.stocksystem.Entity.Stock;
import com.hand.stocksystem.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class StockInfo {
    @Autowired
    private StockService stockService;
    @RequestMapping("/stocklist")
    public List<Stock> getStockList(){
        return stockService.getStockList();
    }
}
