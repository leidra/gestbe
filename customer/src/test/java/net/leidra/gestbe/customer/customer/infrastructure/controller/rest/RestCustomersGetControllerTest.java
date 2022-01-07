package net.leidra.gestbe.customer.customer.infrastructure.controller.rest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;

@RunWith(Cucumber.class)
@ActiveProfiles({"test"})
@CucumberOptions(features = "classpath:gherkin", glue = "net.leidra.gestbe.customer")
public final class RestCustomersGetControllerTest {
}
