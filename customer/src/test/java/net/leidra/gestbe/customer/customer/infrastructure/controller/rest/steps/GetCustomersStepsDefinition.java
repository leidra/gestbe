package net.leidra.gestbe.customer.customer.infrastructure.controller.rest.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.leidra.gestbe.customer.customer.infrastructure.controller.CustomersResponse;
import net.leidra.gestbe.customer.customer.infrastructure.repository.jdbc.JdbcCustomersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static net.leidra.gestbe.customer.customer.infrastructure.controller.rest.steps.ScenarioContext.ScenarioContextKeys.RESPONSE;
import static org.assertj.core.api.Assertions.assertThat;

public final class GetCustomersStepsDefinition extends CucumberCustomersContext {

    public GetCustomersStepsDefinition(RestTemplate restTemplate, JdbcCustomersRepository repository, ObjectMapper objectMapper, ScenarioContext context) {
        super(restTemplate, repository, objectMapper, context);
    }

    @When("I send a GET request to {string}")
    public void when_a_get_is_sent(String endPoint) {
        context.add(RESPONSE, restTemplate.getForEntity("http://localhost:" + port + endPoint, CustomersResponse.class));
    }

    @And("a response body content like")
    public void a_body_content_like(String docString) throws JsonProcessingException {
        final CustomersResponse expectedCustomersResponse = objectMapper.readValue(docString, CustomersResponse.class);
        final ResponseEntity<?> customersResponse = (ResponseEntity<?>) context.get(RESPONSE);
        assertThat(customersResponse.getBody()).isEqualTo(expectedCustomersResponse);
    }

}
