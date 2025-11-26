package com.neueda.stocks.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "trade_status")
public class TradeStatus {

    @Id
    private Long id;

    @Column(name = "status_code", nullable = false)
    private int statusCode;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    @JsonIgnore
    private TradeInfo tradeInfo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public TradeStatus() {
    }

    public TradeInfo getTradeInfo() {
        return tradeInfo;
    }

    public void setTradeInfo(TradeInfo tradeInfo) {
        this.tradeInfo = tradeInfo;
    }
}
