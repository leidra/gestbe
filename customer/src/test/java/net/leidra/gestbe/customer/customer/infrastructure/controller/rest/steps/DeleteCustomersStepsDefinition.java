package net.leidra.gestbe.customer.customer.infrastructure.controller.rest.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.When;
import net.leidra.gestbe.customer.customer.infrastructure.controller.CustomersResponse;
import net.leidra.gestbe.customer.customer.infrastructure.repository.jdbc.JdbcCustomersRepository;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import static net.leidra.gestbe.customer.customer.infrastructure.controller.rest.steps.ScenarioContext.ScenarioContextKeys.ENDPOINT;
import static net.leidra.gestbe.customer.customer.infrastructure.controller.rest.steps.ScenarioContext.ScenarioContextKeys.RESPONSE;

public final class DeleteCustomersStepsDefinition extends CucumberCustomersContext {

    public DeleteCustomersStepsDefinition(RestTemplate restTemplate, JdbcCustomersRepository repository, ObjectMapper objectMapper, ScenarioContext context) {
        super(restTemplate, repository, objectMapper, context);
    }

    @When("I send a DELETE request to {string}")
    public void when_a_delete_is_sent(String endPoint) {
        context.add(ENDPOINT, "http://localhost:" + port + endPoint);
        context.add(RESPONSE, restTemplate.exchange("http://localhost:" + port + endPoint, HttpMethod.DELETE, null, CustomersResponse.class));
    }

}
