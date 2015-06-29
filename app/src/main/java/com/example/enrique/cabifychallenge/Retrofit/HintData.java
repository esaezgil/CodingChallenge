
package com.example.enrique.cabifychallenge.Retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import javax.annotation.Generated;

//@Generated("org.jsonschema2pojo")
public class HintData {
    @SerializedName("locations")
    private List<String> locations = new ArrayList<String>();
    @SerializedName("checksum")
    private double checksum;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The locations
     */
    public List<String> getLocations() {
        return locations;
    }

    /**
     * 
     * @param locations
     *     The locations
     */
    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    /**
     * 
     * @return
     *     The checksum
     */
    public double getChecksum() {
        return checksum;
    }

    /**
     * 
     * @param checksum
     *     The checksum
     */
    public void setChecksum(double checksum) {
        this.checksum = checksum;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
