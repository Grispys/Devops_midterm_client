package org.example.http.cli;

import org.example.domain.Aircraft;
import org.example.domain.Airport;
import org.example.domain.City;
import org.example.http.client.RESTClient;

import java.util.List;

public class HTTPRestCLIApp {
    private RESTClient restClient;

//this is for the first question: "What airports are in what cities?" this will show all cities and what airports are in them.
    public String generateCityReport() {
        System.out.println("Question 1: ");
        List<City> cities = getRestClient().getAllCities();

        StringBuilder report = new StringBuilder();
//iterates through all cities and yoinks the info from them to display
        for (City city : cities) {
            report.append("In the city of ");
            report.append(city.getName());
            report.append(" In the province of ");
            report.append(city.getProvince());
            report.append(", here are all the airports: ");
            report.append(city.getAirports());

            if (cities.indexOf(city) != (cities.size() - 1)) {
                report.append(",\n"); //newline so its a little cleaner
            }
        }

        System.out.println(report.toString());


        return report.toString();
    }
//question 2 - List all aircraft passengers have travelled on? i.e list all aircrafts that have passengers attached to them
    public String generateAircraftPassengersReport() {
        System.out.println("Question 2: ");
        List<Aircraft> aircrafts = getRestClient().getAllAircrafts();

        StringBuilder report = new StringBuilder();

        for (Aircraft aircraft : aircrafts) {
            report.append("The aircraft ");
            report.append(aircraft.getType());
            report.append(" which belongs to the ");
            report.append(aircraft.getAirlineName());
            report.append(", has these passengers: ");
            report.append(aircraft.getPassengers());

            if (aircrafts.indexOf(aircraft) != (aircrafts.size() - 1)) {
                report.append(",\n"); //newline so its a little cleaner
            }
        }

        System.out.println(report.toString());


        return report.toString();
    }



    //question 3 - list all aircrafts that have airports attached to them (where they can land and take off)
    public String generateAircraftAirportReport() {
        System.out.println("Question 3: ");
        List<Aircraft> aircrafts = getRestClient().getAllAircrafts();

        StringBuilder report = new StringBuilder();

        for (Aircraft aircraft : aircrafts) {
            report.append("The aircraft ");
            report.append(aircraft.getType());
            report.append(" which belongs to the ");
            report.append(aircraft.getAirlineName());
            report.append(", can land and take off from these airports: ");
            report.append(aircraft.getPassengers());

            if (aircrafts.indexOf(aircraft) != (aircrafts.size() - 1)) {
                report.append(",\n"); //newline so its a little cleaner
            }
        }

        System.out.println(report.toString());


        return report.toString();
    }






    public RESTClient getRestClient() {
        if (restClient == null) {
            restClient = new RESTClient();
        }

        return restClient;
    }

    public void setRestClient(RESTClient restClient) {
        this.restClient = restClient;
    }


    public static void main(String[] args) {
        HTTPRestCLIApp cliApp = new HTTPRestCLIApp();
//        i cant remember how to change the serverURL dependant on the function call
//        so i'm just gonna comment out and in the ones i need until i do
//        String serverURL = "http://localhost:8080/api/cities";
        String serverURL = "http://localhost:8080/api/aircrafts";
//        String serverURL = "http://localhost:8080/api/airports";
//        String serverURL = "http://localhost:8080/api/passengers";
        RESTClient restClient = new RESTClient();
        restClient.setServerURL(serverURL);
        cliApp.setRestClient(restClient);

        cliApp.generateCityReport();
        cliApp.generateAircraftPassengersReport();
    }




}
