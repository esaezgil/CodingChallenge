
package com.example.enrique.cabifychallenge.Retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;
//import javax.annotation.Generated;

//@Generated("org.jsonschema2pojo")
public class RouteSummary {

    @SerializedName("end_point")
    private String endPoint;
    @SerializedName("start_point")
    private String startPoint;
    @SerializedName("total_time")
    private int totalTime;
    @SerializedName("total_distance")
    private int totalDistance;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The endPoint
     */
    public String getEndPoint() {
        return endPoint;
    }

    /**
     * 
     * @param endPoint
     *     The end_point
     */
    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    /**
     * 
     * @return
     *     The startPoint
     */
    public String getStartPoint() {
        return startPoint;
    }

    /**
     * 
     * @param startPoint
     *     The start_point
     */
    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    /**
     * 
     * @return
     *     The totalTime
     */
    public int getTotalTime() {
        return totalTime;
    }

    /**
     * 
     * @param totalTime
     *     The total_time
     */
    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    /**
     * 
     * @return
     *     The totalDistance
     */
    public int getTotalDistance() {
        return totalDistance;
    }

    /**
     * 
     * @param totalDistance
     *     The total_distance
     */
    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
