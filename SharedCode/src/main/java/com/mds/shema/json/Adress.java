
package com.mds.shema.json;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "adress",
    "ville"
})
public class Adress {

    @JsonProperty("adress")
    private String adress;
    @JsonProperty("ville")
    private String ville;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("adress")
    public String getAdress() {
        return adress;
    }

    @JsonProperty("adress")
    public void setAdress(String adress) {
        this.adress = adress;
    }

    @JsonProperty("ville")
    public String getVille() {
        return ville;
    }

    @JsonProperty("ville")
    public void setVille(String ville) {
        this.ville = ville;
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
