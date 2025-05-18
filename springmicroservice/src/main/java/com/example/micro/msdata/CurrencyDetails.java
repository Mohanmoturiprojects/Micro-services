package com.example.micro.msdata;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class CurrencyDetails {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String fromCurrency;
	
	private String toCurrency;
	private double quantity;
	private double coversionRate;
	private double totalammout;
}
