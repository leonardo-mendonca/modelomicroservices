package br.com.leonardo.rest;

import java.util.Date;

public class Venda {

	private long id;

	private long amount;

	private Date orderDate;

	private Cliente cliente;

	private Produto produto;
	
	private String message;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Cliente getCustomer() {
		return cliente;
	}

	public void setCustomer(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduct() {
		return produto;
	}

	public void setProduct(Produto produto) {
		this.produto = produto;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
