package net.leidra.gestbe.customer.customer.infrastructure.controller.rest.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.leidra.gestbe.customer.customer.infrastructure.controller.CustomersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public final class GetCustomersStepsDefinition {
    @LocalServerPort
    private int port;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    private ResponseEntity<CustomersResponse> customersResponse;

    @Given("^a customer with id a26f508e-b442-4311-b604-1d0a82a98177 exists$")
    public void given_a_customer_exist() {
    }

    @When("I send a GET request to {string}")
    public void when_a_get_is_sent(String endPoint) {
        customersResponse = restTemplate.getForEntity("http://localhost:" + port + endPoint, CustomersResponse.class);
    }

    @Then("the server return a {int} status code")
    public void the_server_return_a_status_code(Integer statusCode) {
        assertThat(customersResponse.getStatusCode()).isEqualTo(HttpStatus.resolve(statusCode));
    }

    @Then("a body content like")
    public void a_body_content_like(String docString) throws JsonProcessingException {
        final CustomersResponse expectedCustomersResponse = objectMapper.readValue(docString, CustomersResponse.class);
        assertThat(customersResponse.getBody()).isEqualTo(expectedCustomersResponse);
    }

}
