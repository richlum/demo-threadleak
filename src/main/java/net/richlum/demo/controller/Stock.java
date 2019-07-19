package net.richlum.demo.controller;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "stock")
public class Stock {

    private Integer stockid;
    private String stockCode;
    private String stockName;
    private StockDetail stockDetail;

    Stock(String stockCode, String stockName, StockDetail stockDetail) {
        this.setStockCode(stockCode);
        this.stockName = stockName;
        this.stockDetail = stockDetail;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public Stock(String stockCode, String stockName) {
        this.setStockCode(stockCode);
        this.stockName = stockName;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "STOCK_ID", unique = true, nullable = false)
    public Integer getStockId() {
        return this.stockid;
    }

    @Column(name = "STOCK_NAME")
    public String getStockName() {
        return this.stockName;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "stock", cascade = CascadeType.ALL)
    public StockDetail getStockDetail() {
        return this.stockDetail;
    }

    public void setStockId(Integer stockid) {
        this.stockid = stockid;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public void setStockDetail(StockDetail stockDetail) {
        this.stockDetail = stockDetail;
    }

}