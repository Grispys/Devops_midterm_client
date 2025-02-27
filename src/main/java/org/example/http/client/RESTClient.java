package org.example.http.client;

import org.example.domain.Aircraft;
import org.example.domain.City;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class RESTClient {

    private String serverURL;
    private HttpClient client;


//    gets response from http via httprequest. structure taken from jamies example
    public String getResponse(){
        String responseBody ="";
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(serverURL)).build();

        try {
            HttpResponse<String> response = getClient().send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()!=200) {
                System.out.println("Status Code: " + response.statusCode());
            }

            responseBody = response.body();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return responseBody;
    }



//    list cities method
    public List<City> getAllCities(){
        setServerURL("http://localhost:8080/api/cities");
        List<City> cities = new ArrayList<City>();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(serverURL)).build();
        try {
            HttpResponse<String> response = getClient().send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()==200) {
                System.out.println("***** " + response.body());
            } else {
                System.out.println("Error Status Code: " + response.statusCode());
            }

            cities = buildCitiesListFromResponse(response.body());


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return cities;

    }

    //    list aircrafts method
    public List<Aircraft> getAllAircrafts(){
        setServerURL("http://localhost:8080/api/aircrafts");
        List<Aircraft> aircrafts = new ArrayList<Aircraft>();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(serverURL)).build();
        try {
            HttpResponse<String> response = getClient().send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()==200) {
                System.out.println("***** " + response.body());
            } else {
                System.out.println("Error Status Code: " + response.statusCode());
            }

            aircrafts = buildAircraftsListFromResponse(response.body());


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return aircrafts;

    }

//    build X list from response methods

    public List<City> buildCitiesListFromResponse(String response) throws JsonProcessingException {
        List<City> cities = new ArrayList<City>();

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        cities = mapper.readValue(response, new TypeReference<List<City>>(){});
        return cities;
    }

    public List<Aircraft> buildAircraftsListFromResponse(String response) throws JsonProcessingException {
        List<Aircraft> aircrafts = new ArrayList<Aircraft>();

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        aircrafts = mapper.readValue(response, new TypeReference<List<Aircraft>>(){});
        return aircrafts;
    }

    public String getServerURL() {
        return serverURL;
    }

    public void setServerURL(String serverURL){
        this.serverURL = serverURL;
    }

    private HttpClient getClient() {
        if(client ==null){
            client = HttpClient.newHttpClient();
        }
        return client;
    }
}
