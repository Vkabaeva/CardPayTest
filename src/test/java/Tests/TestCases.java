package Tests;

import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.parsing.Parser;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class TestCases {

    private String format;
    private int number;
    private Response response;

    @Given("^parameters (\\d+) and (\\d+)$")
    public void parameters_format_and_number(String format, int number) {
        this.format = format;
        this.number = number;
    }

    private static String baseURL = "http://fish-text.ru/get";
    private static Response request(String type, int number, String format) {
        return given()
                .queryParam("type", type)
                .queryParam("number", number)
                .queryParam("format", format)
                .get(baseURL);
    }
    @When("send GET request")
    public void sendGET() {
        RestAssured.registerParser("text/html", Parser.JSON);
        response = request(format, number, "json");
    }

    @And("result field in response should be '(.*)'$")
    public void resultSuccess(String expectedStatus) {
        response.then().body("status", is(expectedStatus));
    }

    private static String getDelimiter(String type, String format) {
        if (type.equals("sentence")) {
            return "[.?!]";
        } else {
            if (format.equals("json")) {
                return "\\\\n\\\\n";
            } else {
                if (type.equals("paragraph")) {
                    return "</p>";
                } else { // TYPE_TITLE
                    return "</h1>";
                }
            }
        }
    }

    private static String countNumber(String responseTest, String type, String format) {
        String[] tokens = responseTest.split(getDelimiter(type, format));
        int countNumberInt = tokens.length;
        return Integer.toString(countNumberInt);
    }

    private static String getInvalid(String type) {
        return "Invalid amount of '" + type + "':";
    }

    @Then("number in response should equal expected")
    public void numberExpected(int expectedNumber) {
        Assert.assertEquals(countNumber(response.jsonPath().getString("text"), format, "json"),
                expectedNumber, getInvalid(format));
    }

    @Then("errorCode should equal expectedErrorCode")
    public void jsonErrorCodeShouldEqualExpected(int errorCode) {
        response.then().body(String.valueOf(errorCode), is(errorCode));
    }

    @And("errorText should equal expectedErrorText")
    public void jsonErrorTextShouldEqualErrorText(String errorText) {
        response.then().body("text", is(errorText));
    }
}