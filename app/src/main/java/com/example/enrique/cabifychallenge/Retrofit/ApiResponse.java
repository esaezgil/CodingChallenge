
package com.example.enrique.cabifychallenge.Retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import javax.annotation.Generated;

//@Generated("org.jsonschema2pojo")
public class ApiResponse {

    @SerializedName("alternative_names")
    private List<List<String>> alternativeNames = new ArrayList<List<String>>();
    @SerializedName("route_name")
    private List<String> routeName = new ArrayList<String>();
    @SerializedName("status_message")
    private String statusMessage;
    @SerializedName("route_geometry")
    private String routeGeometry;
    @SerializedName("route_summary")
    private RouteSummary routeSummary;
    @SerializedName("f")
    private boolean foundAlternative;
    @SerializedName("alternative_summaries")
    private List<AlternativeSummary> alternativeSummaries = new ArrayList<AlternativeSummary>();
    @SerializedName("via_points")
    private List<List<Float>> viaPoints = new ArrayList<List<Float>>();
    @SerializedName("status")
    private int status;
    @SerializedName("via_indices")
    private List<Integer> viaIndices = new ArrayList<Integer>();
    @SerializedName("hint_data")
    private HintData hintData;
    @SerializedName("alternative_geometries")
    private List<String> alternativeGeometries = new ArrayList<String>();
    @SerializedName("alternative_indices")
    private List<Integer> alternativeIndices = new ArrayList<Integer>();

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The alternativeNames
     */
    public List<List<String>> getAlternativeNames() {
        return alternativeNames;
    }

    /**
     * 
     * @param alternativeNames
     *     The alternative_names
     */
    public void setAlternativeNames(List<List<String>> alternativeNames) {
        this.alternativeNames = alternativeNames;
    }

    /**
     * 
     * @return
     *     The routeName
     */
    public List<String> getRouteName() {
        return routeName;
    }

    /**
     * 
     * @param routeName
     *     The route_name
     */
    public void setRouteName(List<String> routeName) {
        this.routeName = routeName;
    }

    /**
     * 
     * @return
     *     The statusMessage
     */
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * 
     * @param statusMessage
     *     The status_message
     */
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    /**
     * 
     * @return
     *     The routeGeometry
     */
    public String getRouteGeometry() {
        return routeGeometry;
    }

    /**
     * 
     * @param routeGeometry
     *     The route_geometry
     */
    public void setRouteGeometry(String routeGeometry) {
        this.routeGeometry = routeGeometry;
    }

    /**
     * 
     * @return
     *     The routeSummary
     */
    public RouteSummary getRouteSummary() {
        return routeSummary;
    }

    /**
     * 
     * @param routeSummary
     *     The route_summary
     */
    public void setRouteSummary(RouteSummary routeSummary) {
        this.routeSummary = routeSummary;
    }

    /**
     * 
     * @return
     *     The foundAlternative
     */
    public boolean isFoundAlternative() {
        return foundAlternative;
    }

    /**
     * 
     * @param foundAlternative
     *     The found_alternative
     */
    public void setFoundAlternative(boolean foundAlternative) {
        this.foundAlternative = foundAlternative;
    }

    /**
     * 
     * @return
     *     The alternativeSummaries
     */
    public List<AlternativeSummary> getAlternativeSummaries() {
        return alternativeSummaries;
    }

    /**
     * 
     * @param alternativeSummaries
     *     The alternative_summaries
     */
    public void setAlternativeSummaries(List<AlternativeSummary> alternativeSummaries) {
        this.alternativeSummaries = alternativeSummaries;
    }

    /**
     * 
     * @return
     *     The viaPoints
     */
    public List<List<Float>> getViaPoints() {
        return viaPoints;
    }

    /**
     * 
     * @param viaPoints
     *     The via_points
     */
    public void setViaPoints(List<List<Float>> viaPoints) {
        this.viaPoints = viaPoints;
    }

    /**
     * 
     * @return
     *     The status
     */
    public int getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The viaIndices
     */
    public List<Integer> getViaIndices() {
        return viaIndices;
    }

    /**
     * 
     * @param viaIndices
     *     The via_indices
     */
    public void setViaIndices(List<Integer> viaIndices) {
        this.viaIndices = viaIndices;
    }

    /**
     * 
     * @return
     *     The hintData
     */
    public HintData getHintData() {
        return hintData;
    }

    /**
     * 
     * @param hintData
     *     The hint_data
     */
    public void setHintData(HintData hintData) {
        this.hintData = hintData;
    }

    /**
     * 
     * @return
     *     The alternativeGeometries
     */
    public List<String> getAlternativeGeometries() {
        return alternativeGeometries;
    }

    /**
     * 
     * @param alternativeGeometries
     *     The alternative_geometries
     */
    public void setAlternativeGeometries(List<String> alternativeGeometries) {
        this.alternativeGeometries = alternativeGeometries;
    }

    /**
     * 
     * @return
     *     The alternativeIndices
     */
    public List<Integer> getAlternativeIndices() {
        return alternativeIndices;
    }

    /**
     * 
     * @param alternativeIndices
     *     The alternative_indices
     */
    public void setAlternativeIndices(List<Integer> alternativeIndices) {
        this.alternativeIndices = alternativeIndices;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
