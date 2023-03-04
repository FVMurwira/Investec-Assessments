package testCases;


import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import jdk.internal.org.objectweb.asm.TypeReference;
import lombok.var;
import models.People;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class peopleApi_Tests {

    @Test
    public void get_All_People_Data()
    {

        ///////Part 1//////////////
        given()

                .when()
                    .get("https://swapi.dev/api/people/")

                .then()

                     .statusCode(200)

                .log()

                       .body();

////Part 2////////////////////////////////////////////////////////////////
       People people = RestAssured.given().get("https://swapi.dev/api/people/").body().as(People.class);


        System.out.println(people.getResults().listIterator(2).next().getName());


        Assertions.assertEquals("white,blue", people.getResults().listIterator(2).next().getSkinColor());



    }


}
