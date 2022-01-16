package net.leidra.gestbe.customer.customer.infrastructure.controller.rest;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.customer.application.save_customer.SaveCustomerCommand;
import net.leidra.gestbe.customer.shared.application.CommandBus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Transactional
@RestController
@AllArgsConstructor
@RequestMapping("/api/customers/{customer_id}")
public class CustomerPutRestController {
    private final CommandBus commandBus;

    @PutMapping
    public ResponseEntity<?> save(@PathVariable("customer_id") final UUID customerId,
                                  @RequestBody final CustomerRequest request) {
        commandBus.dispatch(new SaveCustomerCommand(customerId, request.name()));

        return ResponseEntity.noContent().build();
    }
}
