package net.froihofer.dsfinancejaxrs.client;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "symbol",
        "companyName",
        "stockExchange",
        "floatShares",
        "lastTradePrice",
        "lastTradeTime",
        "marketCapitalization"
})
@Generated("jsonschema2pojo")
public class StockJson {

    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("companyName")
    private String companyName;
    @JsonProperty("stockExchange")
    private String stockExchange;
    @JsonProperty("floatShares")
    private Long floatShares;
    @JsonProperty("lastTradePrice")
    private Double lastTradePrice;
    @JsonProperty("lastTradeTime")
    private Long lastTradeTime;
    @JsonProperty("marketCapitalization")
    private Long marketCapitalization;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @JsonProperty("companyName")
    public String getCompanyName() {
        return companyName;
    }

    @JsonProperty("companyName")
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @JsonProperty("stockExchange")
    public String getStockExchange() {
        return stockExchange;
    }

    @JsonProperty("stockExchange")
    public void setStockExchange(String stockExchange) {
        this.stockExchange = stockExchange;
    }

    @JsonProperty("floatShares")
    public Long getFloatShares() {
        return floatShares;
    }

    @JsonProperty("floatShares")
    public void setFloatShares(Long floatShares) {
        this.floatShares = floatShares;
    }

    @JsonProperty("lastTradePrice")
    public Double getLastTradePrice() {
        return lastTradePrice;
    }

    @JsonProperty("lastTradePrice")
    public void setLastTradePrice(Double lastTradePrice) {
        this.lastTradePrice = lastTradePrice;
    }

    @JsonProperty("lastTradeTime")
    public Long getLastTradeTime() {
        return lastTradeTime;
    }

    @JsonProperty("lastTradeTime")
    public void setLastTradeTime(Long lastTradeTime) {
        this.lastTradeTime = lastTradeTime;
    }

    @JsonProperty("marketCapitalization")
    public Long getMarketCapitalization() {
        return marketCapitalization;
    }

    @JsonProperty("marketCapitalization")
    public void setMarketCapitalization(Long marketCapitalization) {
        this.marketCapitalization = marketCapitalization;
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



