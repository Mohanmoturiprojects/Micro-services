package com.example.micro.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "CURRENCY_EXCHANGE")
public class CurrencyExchange {
		@Id
		//@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
	
	    @Column(name = "FROM_CURRENCY")
	    private String fromCurrency;

	    @Column(name = "TO_CURRENCY")
	    private String toCurrency;

	    @Column(name = "CONVERSION_RATE")
	    private double conversionRate;
	

}
