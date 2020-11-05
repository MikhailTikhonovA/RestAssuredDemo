package apiTests.tests;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import pojos.listPlaces.Place;
import pojos.listPlaces.Places;
import utill.Paths;
import utill.PrivateData;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static specifications.RqRsSpecifications.getRequestSpecification;
import static specifications.RqRsSpecifications.getResponseSpecification;

public class BaseTest {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    Places places;

    @Step("Пройти авторизацию по токену")
    public RequestSpecification sendRequest(String uri, String path) {
        requestSpecification = given().header("x-rapidapi-key", PrivateData.token)
                .header("x-rapidapi-host", PrivateData.host)
                .spec(getRequestSpecification(uri, path));
        return requestSpecification;
    }

    @Step("Установить параметры города \"{city}\" страны \"{country}\" валюты \"{currency}\" язык \"{local}\"")
    public Response setParamsDestination(String city, String country, String currency, String local) {
        response = requestSpecification.when().get(Paths.getPath(city, country, currency, local));
        return response;
    }

    @Step("Проверить статус код \"{statusCode}\"")
    public ValidatableResponse validateStatusCode(Integer statusCode) {
        validatableResponse = response.then()
                .spec(getResponseSpecification(statusCode));
        return validatableResponse;
    }

    @Step("Проверить ответ по схеме \"{scheme}\"")
    public ValidatableResponse validateScheme(String scheme) {
        validatableResponse = response.then()
                .assertThat().body(matchesJsonSchemaInClasspath(scheme));
        return validatableResponse;
    }

    @Step("Распарсить ответ в Pojo")
    public Places getPlacesAsPojo(){
        return validatableResponse.extract().as(Places.class);
    }
}
