package com.neueda.stocks.repository;

import com.neueda.stocks.model.TradeStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeStatusRepository extends JpaRepository<TradeStatus, Long> {
}
