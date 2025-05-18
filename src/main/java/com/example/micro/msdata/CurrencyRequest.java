package com.example.micro.msdata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyRequest {
	private String fromCurrency;
	private String toCurrency;
	private double quantity; 
	

}
