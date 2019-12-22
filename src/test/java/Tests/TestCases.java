package Tests;

import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.junit.Assert;

import static Tests.Utils.*;
import static org.hamcrest.CoreMatchers.is;

public class TestCases {

    private String type;
    private int number;
    private Response response;

    @Given("^two parameters (.*) and (-?\\d+)$")
    public void typeAndNumber(String type, int number) {
        this.type = type;
        this.number = number;
    }

    @When("^send GET request, specifying two parameters, in order to get json$")
    public void sendGETRequestSpecifyingTwoParametersTypeOfTheReturningTextAndNumberOfItemsInOrderToGetJson() {
        RestAssured.registerParser("text/html", Parser.JSON);
        response = request(type, number, "json");
    }

    @Then("^the status code should be (\\d+)$")
    public void theStatusCodeShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @And("^result field in json should be '(.*)'$")
    public void resultFieldInJsonShouldBeSuccess(String expectedStatus) {
        response.then().body(status, is(expectedStatus));
    }

    @And("^number of elements in json should equal (\\d+)$")
    public void numberOfElementsShouldEqualExpected(int expectedNumber) {
        Assert.assertEquals(countItemsNumber(response.jsonPath().getString(text), type, formatJSON),
                expectedNumber, getInvalidAmountMessage(type));
    }


    @When("^send GET request, specifying two parameters, in order to get html$")
    public void sendGETRequestSpecifyingTwoParametersTypeOfTheReturningTextAndNumberOfItemsInOrderToGetHtml() {
        response = request(type, number, formarHTML);
    }

    @And("^number of elements in html should equal (\\d+)$")
    public void numberOfElementsInHtmlShouldEqualExpected(int expectedNumber) {
        Assert.assertEquals(countItemsNumber(response.then().extract().asString(), type, formarHTML),
                expectedNumber, getInvalidAmountMessage(type));
    }

    @And("^json error code should equal (\\d+)$")
    public void jsonErrorCodeShouldEqualExpected(int errorCode) {
        response.then().body(String.valueOf(errorCode), is(errorCode));
    }

    @And("^json error text should equal (.*)$")
    public void jsonErrorTextShouldEqualErrorText(String errorText) {
        response.then().body(text, is(errorText));
    }

    @And("^html text should equal (.*)$")
    public void htmlTextShouldEqualErrorText(String errorText) {
        Assert.assertEquals(response.then().extract().asString(), errorText);
    }
}
