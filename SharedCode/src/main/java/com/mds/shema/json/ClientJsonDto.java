
package com.mds.shema.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "codeInterne",
    "clientName",
    "clientPhone",
    "codeExterne",
    "email",
    "clientType",
    "clientEtat",
    "identifiant",
    "contacts",
    "adresses"
})
@ToString
public class ClientJsonDto {

    @JsonProperty("codeInterne")
    private Integer codeInterne;
    @JsonProperty("clientName")
    private String clientName;
    @JsonProperty("clientPhone")
    private String clientPhone;
    @JsonProperty("codeExterne")
    private String codeExterne;
    @JsonProperty("email")
    private String email;
    @JsonProperty("clientType")
    private Integer clientType;
    @JsonProperty("clientEtat")
    private Integer clientEtat;
    @JsonProperty("identifiant")
    private String identifiant;
    @JsonProperty("contacts")
    private List<Contact> contacts = null;
    @JsonProperty("adresses")
    private List<Adress> adresses = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("codeInterne")
    public Integer getCodeInterne() {
        return codeInterne;
    }

    @JsonProperty("codeInterne")
    public void setCodeInterne(Integer codeInterne) {
        this.codeInterne = codeInterne;
    }

    @JsonProperty("clientName")
    public String getClientName() {
        return clientName;
    }

    @JsonProperty("clientName")
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @JsonProperty("clientPhone")
    public String getClientPhone() {
        return clientPhone;
    }

    @JsonProperty("clientPhone")
    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    @JsonProperty("codeExterne")
    public String getCodeExterne() {
        return codeExterne;
    }

    @JsonProperty("codeExterne")
    public void setCodeExterne(String codeExterne) {
        this.codeExterne = codeExterne;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("clientType")
    public Integer getClientType() {
        return clientType;
    }

    @JsonProperty("clientType")
    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }

    @JsonProperty("clientEtat")
    public Integer getClientEtat() {
        return clientEtat;
    }

    @JsonProperty("clientEtat")
    public void setClientEtat(Integer clientEtat) {
        this.clientEtat = clientEtat;
    }

    @JsonProperty("identifiant")
    public String getIdentifiant() {
        return identifiant;
    }

    @JsonProperty("identifiant")
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    @JsonProperty("contacts")
    public List<Contact> getContacts() {
        return contacts;
    }

    @JsonProperty("contacts")
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @JsonProperty("adresses")
    public List<Adress> getAdresses() {
        return adresses;
    }

    @JsonProperty("adresses")
    public void setAdresses(List<Adress> adresses) {
        this.adresses = adresses;
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
