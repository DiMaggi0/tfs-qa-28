package ru.tinkoff.qa.apimodels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category{



	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public Category setName(String name) {
		this.name = name;
		return this;
	}

	public Category setId(int id) {
		this.id = id;
		return this;
	}
}