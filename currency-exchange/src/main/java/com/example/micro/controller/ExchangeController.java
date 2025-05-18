package com.example.micro.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.micro.data.CurrencyExchange;
import com.example.micro.repository.ExchangeRepository;

@RestController
@RequestMapping("/api/v1")
public class ExchangeController {
	@Autowired
	ExchangeRepository exchangeRepository;
	

	
    @GetMapping("/from/{from}/to/{to}")
    public ResponseEntity< Double > getExchangeValue(@PathVariable("from") String from,
                                                              @PathVariable("to") String to) {
    	System.out.println("enter into action method");
        
        CurrencyExchange exchange = exchangeRepository.findByFromCurrencyAndToCurrency(from, to);

        if (exchange != null) {
            return ResponseEntity.status(HttpStatus.OK)
                                 .header("info", "data found")
                                 .body(exchange.getConversionRate());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .header("info", "data not found")
                                 .body(0.0);
        }
    }
	
	

}
