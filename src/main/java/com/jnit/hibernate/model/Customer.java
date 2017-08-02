package com.jnit.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	private String customerName;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Order> ordersPlaced = new ArrayList<Order>();

	public Customer(){
		
	}
	public Customer(Long customerId, String customerName, List<Order> ordersPlaced) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.ordersPlaced = ordersPlaced;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Order> getOrdersPlaced() {
		return ordersPlaced;
	}

	public void setOrdersPlaced(List<Order> ordersPlaced) {
		this.ordersPlaced = ordersPlaced;
	}

	/*@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", ordersPlaced="
				+ ordersPlaced + "]";
	}*/

}