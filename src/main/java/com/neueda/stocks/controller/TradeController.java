package com.neueda.stocks.controller;


import com.neueda.stocks.dto.TradeRequest;
import com.neueda.stocks.model.TradeInfo;
import com.neueda.stocks.service.TradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trades")
public class TradeController {

    private final TradeService tradeService;

    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TradeInfo> getTrade(@PathVariable Long id) {
        TradeInfo tradeInfo = tradeService.getTrade(id);
        if (tradeInfo != null) {
            return ResponseEntity.ok(tradeInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TradeInfo> createTrade(@RequestBody TradeRequest tradeRequest) {
        TradeInfo tradeInfo = new TradeInfo();
        tradeInfo.setStockTicker(tradeRequest.getStockTicker());
        tradeInfo.setVolume(tradeRequest.getVolume());
        tradeInfo.setPrice(tradeRequest.getPrice());
        tradeInfo.setBuyOrSell(tradeRequest.getBuyOrSell());

        TradeInfo createdTrade = tradeService.createTrade(tradeInfo, tradeRequest.getStatusCode());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTrade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrade(@PathVariable Long id) {
        boolean exists = tradeService.getTrade(id) != null;
        tradeService.deleteTrade(id);
        if (exists) {
            return ResponseEntity.ok("Trade deleted: "+id+" successfully");
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping
    public ResponseEntity<List<TradeInfo>> getAllTrades() {
        List<TradeInfo> trades = tradeService.getAllTrades();
        return ResponseEntity.ok(trades);
    }

}


