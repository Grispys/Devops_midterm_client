package org.example.http.client;

import org.example.domain.City;

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

    private HttpClient getClient() {
        return client;
    }

//    list cities method
    public List<City> getAllCities(){
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

    public List<City> buildCitiesListFromResponse(String response){

    }

}
