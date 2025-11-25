package com.neueda.stocks.repository;

import com.neueda.stocks.model.TradeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeInfoRepository  extends JpaRepository<TradeInfo, Long> {
}
