package com.example.lab10.model;
//BVIDHYASAGAR..AF0320724
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;

@Entity
@Table(name="cart")

public class Cart 
{
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="cart_id")
	 private int id;
	   
	 @Column(name="item_name")
	 private String name;
	   
	 @ManyToMany
	 @JoinTable(name="cart_product",joinColumns=@JoinColumn(name="cart_id"),
	 inverseJoinColumns=@JoinColumn(name="product_id"))
	 private Set<Product> items=new HashSet<Product>();

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int id, String name, Set<Product> items) {
		super();
		this.id = id;
		this.name = name;
		this.items = items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getItems() {
		return items;
	}

	public void setItems(Set<Product> items) {
		this.items = items;
	}
}
