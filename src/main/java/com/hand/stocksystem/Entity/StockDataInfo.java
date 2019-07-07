package com.hand.stocksystem.Entity;

public class StockDataInfo {
    private int Stockid;

    public int getStockid() {
        return Stockid;
    }

    public void setStockid(int stockid) {
        Stockid = stockid;
    }

    private String StockCode;
    private String StockData;

    public String getStockCode() {
        return StockCode;
    }

    public void setStockCode(String stockCode) {
        StockCode = stockCode;
    }

    public String getStockData() {
        return StockData;
    }

    public void setStockData(String stockData) {
        StockData = stockData;
    }

    public String getStockPrice() {
        return StockPrice;
    }

    public void setStockPrice(String stockPrice) {
        StockPrice = stockPrice;
    }

    private String StockPrice;
}
