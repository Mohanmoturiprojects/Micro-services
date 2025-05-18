package com.example.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.micro.data.CurrencyExchange;

@Repository
public interface ExchangeRepository  extends JpaRepository<CurrencyExchange, Long>{

	CurrencyExchange findByFromCurrencyAndToCurrency(String from, String to);

}
