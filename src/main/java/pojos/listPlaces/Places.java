package pojos.listPlaces;

import com.fasterxml.jackson.annotation.*;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"Places"})
public class Places {

    @JsonProperty("Places")
    private List<Place> places = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Places")
    public List<Place> getPlaces() {
        return places;
    }

    @JsonProperty("Places")
    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Step("Проверить количество аэропортов в городе \"{numbers}\"")
    public Places checkCountAirports(int numbers) {
        Assertions.assertEquals(places.size(), numbers, "Количество аэропортов в городе не соответствует ожидаемому");
        return this;
    }

    @Step("Проверить наличие PlaceName: \"{placeName}\" ")
    public Places checkAirports(String placeName) {
        boolean isExist = places.stream().anyMatch(place -> place.getPlaceName().equals(placeName));
        Assertions.assertTrue(isExist, "Ответ не содержит " + placeName);
        return this;
    }

    @Step("Проверить страну в каждом из блоков \"{country}\"")
    public Places checkCountryInAnswer(String country) {
        boolean result = places.stream().allMatch(place -> place.getCountryName().equals(country));
        Assertions.assertTrue(result, "Ответ содержит другие страны кроме " + country);
        return this;
    }



}
