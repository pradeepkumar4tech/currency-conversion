package com.springboot.currencyconversion.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springboot.currencyconversion.bean.CurrencyConversionBean;
import com.springboot.currencyconversion.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionServiceController {

	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;
	
	
	@GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean getCurrencyConversionAmount(@PathVariable String from, @PathVariable String to,
			@PathVariable String quantity) {
		RestTemplate restTemplate = new RestTemplate();
		HashMap<String, String> currency_conversion_parameters = new HashMap<String, String>();
		currency_conversion_parameters.put("from", from);
		currency_conversion_parameters.put("to", to);
		ResponseEntity<CurrencyConversionBean> responseEntity = restTemplate.getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				currency_conversion_parameters);
		CurrencyConversionBean currencyConversionBean = responseEntity.getBody();
		return new CurrencyConversionBean(currencyConversionBean.getId(), from, to,
				currencyConversionBean.getConversionMultiple(), currencyConversionBean.getEnvironment(),
				Integer.parseInt(quantity),
				new BigDecimal(quantity).multiply(currencyConversionBean.getConversionMultiple()));

	}
	

	@GetMapping("currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean getCurrencyConversionAmountFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable String quantity) {
		System.out.println("Inside feign call");
		CurrencyConversionBean currencyConversionBean = currencyExchangeProxy.convertCurrency(from, to);
		return new CurrencyConversionBean(currencyConversionBean.getId(), from, to,
				currencyConversionBean.getConversionMultiple(), currencyConversionBean.getEnvironment(),
				Integer.parseInt(quantity),
				new BigDecimal(quantity).multiply(currencyConversionBean.getConversionMultiple()));

	}
}
