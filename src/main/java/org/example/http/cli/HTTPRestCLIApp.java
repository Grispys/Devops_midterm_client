package org.example.http.cli;

import org.example.domain.Aircraft;
import org.example.domain.City;
import org.example.http.client.RESTClient;

import java.util.List;

public class HTTPRestCLIApp {
    private RESTClient restClient;

//this is for the first question: "What airports are in what cities?" this will show all cities and what airports are in them.
    public String generateCityReport() {
        System.out.println("\u001B[36m" + "Question 1: " + "\u001B[97m" );
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
        System.out.println("\u001B[36m" + "Question 2: " + "\u001B[97m" );
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
        System.out.println("\u001B[36m" + "Question 3: " + "\u001B[97m");
        List<Aircraft> aircrafts = getRestClient().getAllAircrafts();

        StringBuilder report = new StringBuilder();

        for (Aircraft aircraft : aircrafts) {
            report.append("The aircraft ");
            report.append(aircraft.getType());
            report.append(" which belongs to the ");
            report.append(aircraft.getAirlineName());
            report.append(", can land and take off from these airports: ");
            report.append(aircraft.getAirports());

            if (aircrafts.indexOf(aircraft) != (aircrafts.size() - 1)) {
                report.append(",\n"); //newline so its a little cleaner
            }
        }

        System.out.println(report.toString());


        return report.toString();
    }



    //question 4 - what airports have passengers used? i think i can figure this out by just listing the airports that are attached to aircrafts that are attached to passengers
    public String generatePassengerAirportReport() {
        System.out.println("\u001B[36m" + "Question 4: " + "\u001B[97m");
        List<Aircraft> aircrafts = getRestClient().getAllAircrafts();

        StringBuilder report = new StringBuilder();

        for (Aircraft aircraft : aircrafts) {
            report.append("These passengers: ");
            report.append(aircraft.getPassengers());
            report.append(" have all used these airports: ");
            report.append(aircraft.getAirports());

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




        RESTClient restClient = new RESTClient();
        cliApp.setRestClient(restClient);

        cliApp.generateCityReport();
        cliApp.generateAircraftPassengersReport();
        cliApp.generateAircraftAirportReport();
        cliApp.generatePassengerAirportReport();
    }




}
