package net.leidra.gestbe.customer.customer.infrastructure.controller.rest.steps;

import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ScenarioScope
public class ScenarioContext {
    private final Map<ScenarioContextKeys, Object> contextKeysObjectMap = new HashMap<>();

    public enum ScenarioContextKeys {
      RESPONSE, REQUEST, ENDPOINT, CUSTOMER_ID
    }

    public void add(ScenarioContextKeys key, Object value) {
        contextKeysObjectMap.put(key, value);
    }

    public Object get(ScenarioContextKeys key) {
        return contextKeysObjectMap.get(key);
    }
}
