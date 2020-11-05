package apiTests.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utill.*;

@Tag("API")
@Owner("Tikhonov Mikhail")
@Feature("Проверка get ListPlaces")
public class ListPlacesTest extends BaseTest {

    @Test
    @DisplayName("Проверка количества аэропортов в городе Москва")
    @Description("Проверка ответа с 6 аэропортами и аэропортом Moscow Sheremetyevo")
    void checkAirportCounts() {
        sendRequest(URIs.URI_BASE, Paths.PATH_LIST_PLACES);
        setParamsDestination(Queries.Moscow, Countries.Russia, Currencies.RUB, Localies.EN_GB);
        validateStatusCode(200);
        getPlacesAsPojo().checkCountAirports(6).checkAirports("Moscow Sheremetyevo");
    }

    @Test
    @DisplayName("Валидация ответа по схеме")
    @Description("Валидация ответа по схеме")
    void checkSchemasAndCountryName() {
        sendRequest(URIs.URI_BASE, Paths.PATH_LIST_PLACES);
        setParamsDestination(Queries.Berlin, Countries.Germany, Currencies.EUR, Localies.EN_GB);
        validateStatusCode(200);
        validateScheme("ListPlaces.json");
        getPlacesAsPojo().checkCountryInAnswer("Germany");
    }




}
