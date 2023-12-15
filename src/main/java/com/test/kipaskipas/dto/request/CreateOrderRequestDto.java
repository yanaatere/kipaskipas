package com.test.kipaskipas.dto.request;

import com.sun.istack.NotNull;

import java.math.BigDecimal;

public class CreateOrderRequestDto {
	@NotNull
	private String customerId;

	@NotNull
	private String productId;

	@NotNull
	private BigDecimal amount;

	@NotNull
	private int quantity = 0;

	public void setAmount(BigDecimal amount){
		this.amount = amount;
	}

	public BigDecimal getAmount(){
		return amount;
	}

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return quantity;
	}

	public void setProductId(String productId){
		this.productId = productId;
	}

	public String getProductId(){
		return productId;
	}

	public void setCustomerId(String customerId){
		this.customerId = customerId;
	}

	public String getCustomerId(){
		return customerId;
	}

	@Override
 	public String toString(){
		return 
			"OrderRequest{" + 
			"amount = '" + amount + '\'' + 
			",quantity = '" + quantity + '\'' + 
			",productId = '" + productId + '\'' + 
			",customerId = '" + customerId + '\'' +
			"}";
		}
}
