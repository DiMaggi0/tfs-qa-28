package ru.tinkoff.qa.apimodels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TagsItem{


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

	public TagsItem setName(String name) {
		this.name = name;
		return this;
	}

	public TagsItem setId(int id) {
		this.id = id;
		return this;
	}
}