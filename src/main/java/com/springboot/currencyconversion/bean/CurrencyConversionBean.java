package com.springboot.currencyconversion.bean;

import java.math.BigDecimal;

public class CurrencyConversionBean {

	private int id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private String environment;
	private int quantity;
	private BigDecimal totalSumOfAmount;
	
	
	public CurrencyConversionBean(int id, String from, String to, BigDecimal conversionMultiple, String environment,
			int quantity, BigDecimal totalSumOfAmount) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.environment = environment;
		this.quantity = quantity;
		this.totalSumOfAmount = totalSumOfAmount;
	}
	public CurrencyConversionBean()
	{
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalSumOfAmount() {
		return totalSumOfAmount;
	}
	public void setTotalSumOfAmount(BigDecimal totalSumOfAmount) {
		this.totalSumOfAmount = totalSumOfAmount;
	}
	
	
	
}
