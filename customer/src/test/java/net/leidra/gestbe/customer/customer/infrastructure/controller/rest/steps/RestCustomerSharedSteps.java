package net.leidra.gestbe.customer.customer.infrastructure.controller.rest.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.leidra.gestbe.customer.customer.domain.model.Customer;
import net.leidra.gestbe.customer.customer.infrastructure.controller.rest.CustomerRequest;
import net.leidra.gestbe.customer.customer.infrastructure.repository.jdbc.JdbcCustomersRepository;
import net.leidra.gestbe.customer.customer.domain.model.AuditDateTime;
import net.leidra.gestbe.customer.customer.domain.model.CustomerId;
import net.leidra.gestbe.customer.customer.domain.model.CustomerName;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

import static net.leidra.gestbe.customer.customer.infrastructure.controller.rest.steps.ScenarioContext.ScenarioContextKeys.*;
import static org.assertj.core.api.Assertions.assertThat;

public final class RestCustomerSharedSteps extends CucumberCustomersContext {
    public RestCustomerSharedSteps(RestTemplate restTemplate, JdbcCustomersRepository repository, ObjectMapper objectMapper, ScenarioContext context) {
        super(restTemplate, repository, objectMapper, context);
    }

    @Given("a customer with id {string} exists")
    public void given_a_customer_exist(String id) {
        context.add(CUSTOMER_ID, id);
        if (!repository.existsById(new CustomerId(id))) {
            Customer customer = new Customer(new CustomerId(id), new CustomerName("name"), new AuditDateTime(LocalDateTime.now()), new AuditDateTime(LocalDateTime.now()));
            repository.save(customer);
        }
    }

    @And("a request body content like:")
    public void a_body_content_like(String body) throws JsonProcessingException {
        String url = context.get(ENDPOINT).toString();
        final CustomerRequest customerRequest = objectMapper.readValue(body, CustomerRequest.class);
        final ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(customerRequest), Object.class);

        context.add(RESPONSE, response);
    }

    @Then("the server return a {int} status code")
    public void the_server_return_a_status_code(Integer statusCode) {
        final ResponseEntity<?> customersResponse = (ResponseEntity<?>) context.get(RESPONSE);
        assertThat(customersResponse.getStatusCode()).isEqualTo(HttpStatus.resolve(statusCode));
    }

}
