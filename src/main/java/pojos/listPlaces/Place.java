package pojos.listPlaces;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonPropertyOrder({
        "PlaceId",
        "PlaceName",
        "CountryId",
        "RegionId",
        "CityId",
        "CountryName"
})
public class Place {

    @JsonProperty("PlaceId")
    private String placeId;
    @JsonProperty("PlaceName")
    private String placeName;
    @JsonProperty("CountryId")
    private String countryId;
    @JsonProperty("RegionId")
    private String regionId;
    @JsonProperty("CityId")
    private String cityId;
    @JsonProperty("CountryName")
    private String countryName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("PlaceId")
    public String getPlaceId() {
        return placeId;
    }

    @JsonProperty("PlaceId")
    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    @JsonProperty("PlaceName")
    public String getPlaceName() {
        return placeName;
    }

    @JsonProperty("PlaceName")
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    @JsonProperty("CountryId")
    public String getCountryId() {
        return countryId;
    }

    @JsonProperty("CountryId")
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @JsonProperty("RegionId")
    public String getRegionId() {
        return regionId;
    }

    @JsonProperty("RegionId")
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    @JsonProperty("CityId")
    public String getCityId() {
        return cityId;
    }

    @JsonProperty("CityId")
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @JsonProperty("CountryName")
    public String getCountryName() {
        return countryName;
    }

    @JsonProperty("CountryName")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
