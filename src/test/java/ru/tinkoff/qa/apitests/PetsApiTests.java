package ru.tinkoff.qa.apitests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.tinkoff.qa.apimodels.AddNewPetRequest;
import ru.tinkoff.qa.apimodels.AddNewPetResponse;
import ru.tinkoff.qa.apimodels.Category;
import ru.tinkoff.qa.apimodels.TagsItem;

import java.util.List;

public class PetsApiTests {
    AddNewPetRequest addNewPetRequest = new AddNewPetRequest();
    @BeforeEach
    public void buildPet() {

        addNewPetRequest.setId(0).
                setName("cat").
                setCategory(new Category().setId(0).setName("cat")).
                setPhotoUrls(List.of("cat")).
                setTags(List.of(new TagsItem().setId(0).setName("cat"))).
                setStatus("available");
    }
    @Test
    public void addTest() {
        RestAssured.given().contentType(ContentType.JSON).body(addNewPetRequest).
                post("https://petstore.swagger.io/v2/pet").
                then().statusCode(200);
    }
    @Test
    public void addNegativeTest() {
        RestAssured.given().contentType(ContentType.JSON).
                post("https://petstore.swagger.io/v2/pet").
                then().statusCode(405);
    }
    @Test
    public void getTest() {
        AddNewPetResponse addNewPetResponse = RestAssured.given().
                contentType(ContentType.JSON).body(addNewPetRequest).
                post("https://petstore.swagger.io/v2/pet").as(AddNewPetResponse.class);
        RestAssured.given().get("https://petstore.swagger.io/v2/pet/" + addNewPetResponse.getId()).then().
                statusCode(200);

    }
    @Test
    public void putTest() {
        RestAssured.given().
                contentType(ContentType.JSON).body(addNewPetRequest).
                post("https://petstore.swagger.io/v2/pet").as(AddNewPetResponse.class);
        addNewPetRequest.setName("dog");
        AddNewPetResponse addNewPetResponse = RestAssured.given().contentType(ContentType.JSON).body(addNewPetRequest)
                .put("https://petstore.swagger.io/v2/pet").as(AddNewPetResponse.class);

        Assertions.assertEquals("dog", addNewPetResponse.getName(), "check update name");

    }

    @Test
    public void deleteTest() {
        AddNewPetResponse addNewPetResponse = RestAssured.given().
                contentType(ContentType.JSON).body(addNewPetRequest).
                post("https://petstore.swagger.io/v2/pet").as(AddNewPetResponse.class);
        RestAssured.given().delete("https://petstore.swagger.io/v2/pet/" + addNewPetResponse.getId()).
                then().statusCode(200);
    }

}
