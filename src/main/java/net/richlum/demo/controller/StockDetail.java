package net.richlum.demo.controller;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "stock_detail")
public
class StockDetail implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer stockId;
    private Stock stock;
    private String compName;
    
    public StockDetail(Stock stock, String compName){
        this.stock=stock;
        this.compName=compName;
    }
    public StockDetail(String compName){
        this.compName=compName;
    }

    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "STOCK_ID", unique = true, nullable = false)
    public Integer getStockId(){
        return this.stockId;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public Stock getStock(){
        return this.stock;
    }

    @Column(name = "COMP_NAME, nullable = false")
    public String getCompName(){
        return this.compName;
    }

    public void setStockId(Integer stockId){
        this.stockId = stockId;
    }

    public void setCompName(String compName){
        this.compName = compName;
    }

    public void setStock(Stock stock){
        this.stock = stock;
    }



}