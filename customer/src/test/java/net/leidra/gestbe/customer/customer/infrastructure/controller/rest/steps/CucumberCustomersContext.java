package net.leidra.gestbe.customer.customer.infrastructure.controller.rest.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.leidra.gestbe.customer.customer.infrastructure.repository.jdbc.JdbcCustomersRepository;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

public class CucumberCustomersContext {
    @LocalServerPort
    protected int port;
    protected RestTemplate restTemplate;
    protected JdbcCustomersRepository repository;
    protected ObjectMapper objectMapper;
    protected ScenarioContext context;

    public CucumberCustomersContext(RestTemplate restTemplate, JdbcCustomersRepository repository, ObjectMapper objectMapper, ScenarioContext context) {
        this.restTemplate = restTemplate;
        this.repository = repository;
        this.objectMapper = objectMapper;
        this.context = context;
    }
}
