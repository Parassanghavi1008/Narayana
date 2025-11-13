package com.project.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest {
    @Test(groups = "API")
    public void testCreateUser() {
        String requestBody = "{\n" +
                "  \"name\": \"Alex Fletcher\",\n" +
                "  \"job\": \"QA Lead\"\n" +
                "}";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("https://reqres.in/api/users");

        System.out.println("Response Body: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertTrue(response.getBody().asString().contains("Alex Fletcher"));
        Assert.assertTrue(response.getBody().asString().contains("QA Lead"));
        Assert.assertTrue(response.getBody().asString().contains("id"));
        Assert.assertTrue(response.getBody().asString().contains("createdAt"));
    }

    @Test(groups = "API")
    public void testGetUser() {
        Response response = RestAssured.get("https://reqres.in/api/users/2");

        System.out.println("Response Body: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains("\"id\": 2"));
        Assert.assertTrue(response.getBody().asString().contains("\"first_name\": \"Janet\""));
    }
}
