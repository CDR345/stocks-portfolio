package com.neueda.stocks.service;

import com.neueda.stocks.model.TradeInfo;
import com.neueda.stocks.model.TradeStatus;
import com.neueda.stocks.repository.TradeInfoRepository;
import com.neueda.stocks.util.TradeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TradeService {

    private final TradeInfoRepository tradeInfoRepository;

    public TradeService(TradeInfoRepository tradeInfoRepository) {
        this.tradeInfoRepository = tradeInfoRepository;
    }

    public TradeInfo createTrade(TradeInfo tradeInfo, String statusCode) {
        TradeStatus tradeStatus = new TradeStatus();
        tradeStatus.setStatusCode(statusCode);
        tradeStatus.setTradeInfo(tradeInfo);
        tradeInfo.setTradeStatus(tradeStatus);

        return tradeInfoRepository.save(tradeInfo);
    }

    public TradeInfo getTrade(Long id) {
        return tradeInfoRepository.findById(id)
                .orElseThrow(()-> new TradeNotFoundException(id));
    }

    public boolean deleteTrade(Long id) {
       TradeInfo trade = tradeInfoRepository.findById(id)
               .orElseThrow(() -> new TradeNotFoundException(id));
         tradeInfoRepository.delete(trade);
         return true;
    }

    public List<TradeInfo> getAllTrades() {
        return tradeInfoRepository.findAll();
    }

}
