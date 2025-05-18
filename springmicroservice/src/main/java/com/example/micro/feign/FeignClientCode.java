package com.example.micro.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange")
public interface FeignClientCode {
    @GetMapping("/api/v1/from/{from}/to/{to}")
    public ResponseEntity< Double > getExchangeValue(@PathVariable("from") String from,
            @PathVariable("to") String to);



}
