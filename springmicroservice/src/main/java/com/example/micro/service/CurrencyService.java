package com.example.micro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.micro.feign.FeignClientCode;
import com.example.micro.msdata.CurrencyDetails;
import com.example.micro.msdata.CurrencyRequest;
import com.example.micro.repository.CurrencyRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
@CircuitBreaker(name = "currencyExchangeCB",fallbackMethod = "getFallbackDetails")
public class CurrencyService {
	@Autowired
	CurrencyRepository currencyRepository;
	
	@Autowired
	FeignClientCode feignClientCode;
	

	public CurrencyDetails getCurrencyDetails(CurrencyRequest currencyRequest) {
		CurrencyDetails details=new CurrencyDetails();
		details.setFromCurrency(currencyRequest.getFromCurrency());
		details.setToCurrency(currencyRequest.getToCurrency());
		details.setQuantity(currencyRequest.getQuantity());
		
		//double  coversionrate=87.12;
		
		Double coversionRate=feignClientCode.getExchangeValue(currencyRequest.getFromCurrency(), currencyRequest.getToCurrency()).getBody();
		details.setCoversionRate(coversionRate);
		
		double  totalammout=currencyRequest.getQuantity() * coversionRate;
		details.setTotalammout(totalammout);
		
		return currencyRepository.save(details);
		
		
	}
/*	public CurrencyDetails getFallbackDetails(CurrencyRequest currencyRequest, Throwable t) {
		CurrencyDetails details=new CurrencyDetails();
		details.setFromCurrency(currencyRequest.getFromCurrency());
		details.setToCurrency(currencyRequest.getToCurrency());
		details.setQuantity(currencyRequest.getQuantity());
		details.setCoversionRate(1.0);
		details.setTotalammout(1.0 * currencyRequest.getQuantity());
		return details;
	}*/
	public CurrencyDetails getFallbackDetails(CurrencyRequest currencyRequest, Throwable t) {
		throw  new RuntimeException("currency exchande service is down.plese try again later");
	}

}


