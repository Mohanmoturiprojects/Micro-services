package com.example.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.micro.msdata.CurrencyDetails;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyDetails, Long> {
	
}