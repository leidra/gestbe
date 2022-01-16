package net.leidra.gestbe.customer.customer.infrastructure.controller.rest;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.customer.application.remove_customer.RemoveCustomerCommand;
import net.leidra.gestbe.customer.shared.application.CommandBus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Transactional
@RestController
@AllArgsConstructor
@RequestMapping("/api/customers/{customer_id}")
public class CustomerDeleteRestController {
    private final CommandBus commandBus;

    @DeleteMapping
    public ResponseEntity<?> remove(@PathVariable("customer_id") final UUID customerId) {
        commandBus.dispatch(new RemoveCustomerCommand(customerId));

        return ResponseEntity.noContent().build();
    }
}
