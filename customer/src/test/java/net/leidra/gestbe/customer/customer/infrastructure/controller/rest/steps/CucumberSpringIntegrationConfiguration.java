package net.leidra.gestbe.customer.customer.infrastructure.controller.rest.steps;

import io.cucumber.spring.CucumberContextConfiguration;
import net.leidra.gestbe.customer.customer.CustomerTestConfiguration;
import net.leidra.gestbe.testcontainer.PostgreSQLTestContainer;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@CucumberContextConfiguration
@Import({CustomerTestConfiguration.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CucumberSpringIntegrationConfiguration extends PostgreSQLTestContainer {
}
