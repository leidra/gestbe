package net.leidra.gestbe.customer.customer.infrastructure.controller.rest.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.leidra.gestbe.customer.customer.domain.model.Customer;
import net.leidra.gestbe.customer.customer.infrastructure.repository.jdbc.JdbcCustomersRepository;
import net.leidra.gestbe.shared.domain.model.CustomerId;
import net.leidra.gestbe.shared.domain.model.CustomerName;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static net.leidra.gestbe.customer.customer.infrastructure.controller.rest.steps.ScenarioContext.ScenarioContextKeys.CUSTOMER_ID;
import static net.leidra.gestbe.customer.customer.infrastructure.controller.rest.steps.ScenarioContext.ScenarioContextKeys.ENDPOINT;
import static org.assertj.core.api.Assertions.assertThat;

public final class PutCustomersStepsDefinition extends CucumberCustomersContext {

    public PutCustomersStepsDefinition(RestTemplate restTemplate, JdbcCustomersRepository repository, ObjectMapper objectMapper, ScenarioContext context) {
        super(restTemplate, repository, objectMapper, context);
    }

    @Given("a customer with id {string} that not exists")
    public void given_a_customer_not_exist(String id) {
        context.add(CUSTOMER_ID, id);
        final CustomerId customerId = new CustomerId(id);
        if (repository.existsById(customerId)) {
            repository.deleteById(customerId);
        }
    }

    @When("I send a PUT request to {string}")
    public void when_a_get_is_sent(String endPoint) {
        context.add(ENDPOINT, "http://localhost:" + port + endPoint);
    }

    @And("the customer is created")
    public void the_customer_is_created() {
        String id = context.get(CUSTOMER_ID).toString();
        assertThat(repository.existsById(new CustomerId(id))).isTrue();
    }

    @And("the customer is saved")
    public void the_customer_is_saved() {
        String id = context.get(CUSTOMER_ID).toString();
        Optional<CustomerName> actual = repository.findById(new CustomerId(id)).map(Customer::name);
        assertThat(actual).isNotEmpty();
        assertThat(actual.get().name()).isEqualTo("cliente modificado");
    }
}
