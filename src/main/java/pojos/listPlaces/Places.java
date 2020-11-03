package pojos.listPlaces;

import com.fasterxml.jackson.annotation.*;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

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
        Assertions.assertEquals(places.size(), numbers);
        return this;
    }
}
