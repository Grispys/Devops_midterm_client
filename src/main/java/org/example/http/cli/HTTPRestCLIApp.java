package org.example.http.cli;

import org.example.domain.Airport;
import org.example.domain.City;
import org.example.http.client.RESTClient;

import java.util.List;

public class HTTPRestCLIApp {

//this is for the first question: "What airports are in what cities?" this will show all cities and what airports are in them.
    public String generateCityReport() {
        List<City> cities = getRestClient().getAllCities();

        StringBuffer report = new StringBuffer();

        for (City city : cities) {
            report.append(city.getName());
            report.append(" - ");
            report.append(city.getProvince());

            if (airports.indexOf(airport) != (airports.size() - 1)) {
                report.append(",");
            }
        }

        System.out.println(report.toString());

        return report.toString();
    }

    public static void main(String[] args) {
        HTTPRestCLIApp cliApp = new HTTPRestCLIApp();
        String serverURL = "http://localhost:8080/api/cities";
        RESTClient restClient = new RESTClient();
        restClient.setServerURL(serverURL);
        cliApp.setRestClient(restClient);

        cliApp.generateCityReport();
    }




}
