package net.leidra.gestbe.customer.customer.infrastructure.controller.rest.steps;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@SelectClasspathResource("gherkin")
@Suite
@IncludeEngines("cucumber")
public final class RunnerTest {
}
