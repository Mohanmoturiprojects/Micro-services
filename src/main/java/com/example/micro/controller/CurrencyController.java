package com.example.micro.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.micro.msdata.CurrencyDetails;
import com.example.micro.msdata.CurrencyRequest;
import com.example.micro.service.CurrencyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1")

@RefreshScope
public class CurrencyController {
	Logger logger=LoggerFactory.getLogger(CurrencyController.class);
	
	@Autowired
	CurrencyService currencyService;
	@Value("${my.custom.property}")
	private String customeMessage;
	
	@PostMapping("/currency")
	public ResponseEntity<CurrencyDetails> getCurrencyDetails(@RequestBody CurrencyRequest currencyRequest) {
		
		logger.trace("this id trace log request"+currencyRequest);
		logger.info("this is info loger"+currencyRequest);
		
	CurrencyDetails currencyDetails=currencyService.getCurrencyDetails(currencyRequest);
	System.out.println("this is config from git"+customeMessage);
	CurrencyDetails details=currencyService.getCurrencyDetails(currencyRequest);
		return ResponseEntity.status(HttpStatus.OK)
				              .header("info", "data saved"+customeMessage)
				              .body(details);
	}
	

}
