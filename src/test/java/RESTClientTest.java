import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.example.domain.Aircraft;
import org.example.domain.Airport;
import org.example.domain.City;
import org.example.http.client.RESTClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

public class RESTClientTest {

    @Mock
    private HttpClient mockHttpClient;
    @Mock
    private HttpResponse<String> mockHttpResponse;
    private RESTClient restClient;

    @BeforeEach
    void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
        restClient = new RESTClient(mockHttpClient); // Inject mocked HttpClient into RESTClient
    }

    @Test
    void testGetAllCities() throws Exception {
        // mock the httpresponse stuff by providing it a city with an airport object
        String jsonResponse = "[{\"name\":\"Toronto\",\"province\":\"Ontario\",\"airports\":[\"YYZ\",\"YTZ\"]}]";
        when(mockHttpResponse.body()).thenReturn(jsonResponse);
        when(mockHttpResponse.statusCode()).thenReturn(200);

        // Mock httpclient to return the response thing
        when(mockHttpClient.send(any(HttpRequest.class), eq(HttpResponse.BodyHandlers.ofString())))
                .thenReturn(mockHttpResponse);

        // get all the cities from the returned response and then check if it's all good
        List<City> cities = restClient.getAllCities();

        // verify the results
        assertNotNull(cities);
        assertEquals(1, cities.size());
        assertEquals("Toronto", cities.getFirst().getName());
        assertEquals("Ontario", cities.getFirst().getProvince());
        System.out.println(cities.getFirst().getAirports());
//        IT WORKS NOW YUAAAAAAAAAAAAAAAAAAAAAAAAAAY
        assertTrue(cities.getFirst().getAirports().stream().map(Airport::getCode).toList().contains("YYZ"));
    }

    @Test
    void testGetAllAircraftAirports() throws Exception {
        // mock the httpresponse stuff. this will add a new aircraft with the airport ids.
        String jsonResponse = "[{" +
                "\"type\":\"Airplane 3000\"," +
                "\"airlineName\":\"Test Airlines\"," +
                "\"numOfPassengers\": 3," +
                "\"airports\":[{\"id\": 2},{\"id\": 3}]" +
                "}]";
        when(mockHttpResponse.body()).thenReturn(jsonResponse);
        when(mockHttpResponse.statusCode()).thenReturn(200);

        // Mock httpclient to return the response thing
        when(mockHttpClient.send(any(HttpRequest.class), eq(HttpResponse.BodyHandlers.ofString())))
                .thenReturn(mockHttpResponse);

        // get all the aircrafts from the fake mock thing
        List<Aircraft> aircrafts = restClient.getAllAircrafts();

        // verify the results
        assertNotNull(aircrafts);
        assertEquals(1, aircrafts.size());
        assertEquals("Airplane 3000", aircrafts.getFirst().getType());
        assertEquals("Test Airlines", aircrafts.getFirst().getAirlineName());
        System.out.println(aircrafts.getFirst().getAirports());
//
//        this test will check if the aircrafts list of airports contains the correct airport id's
        assertTrue(aircrafts.getFirst().getAirports().stream().map(Airport::getId).toList().contains(2L));
        assertTrue(aircrafts.getFirst().getAirports().stream().map(Airport::getId).toList().contains(3L));
    }


}
