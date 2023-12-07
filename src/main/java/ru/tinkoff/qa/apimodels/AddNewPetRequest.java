package ru.tinkoff.qa.apimodels;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddNewPetRequest{

	@JsonProperty("photoUrls")
	private List<String> photoUrls;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	@JsonProperty("category")
	private Category category;

	@JsonProperty("tags")
	private List<TagsItem> tags;

	@JsonProperty("status")
	private String status;

	public AddNewPetRequest setPhotoUrls(List<String> photoUrls){
		this.photoUrls = photoUrls;
		return this;
	}

	public List<String> getPhotoUrls(){
		return photoUrls;
	}

	public AddNewPetRequest setName(String name){
		this.name = name;
		return this;
	}

	public String getName(){
		return name;
	}

	public AddNewPetRequest setId(int id){
		this.id = id;
		return this;
	}

	public int getId(){
		return id;
	}

	public AddNewPetRequest setCategory(Category category){
		this.category = category;
		return this;
	}

	public Category getCategory(){
		return category;
	}

	public AddNewPetRequest setTags(List<TagsItem> tags){
		this.tags = tags;
		return this;
	}

	public List<TagsItem> getTags(){
		return tags;
	}

	public AddNewPetRequest setStatus(String status){
		this.status = status;
		return this;
	}

	public String getStatus(){
		return status;
	}
}