package net.leidra.gestbe.customer.customer.infrastructure.controller.rest;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.customer.application.save_customer.SaveCustomerCommand;
import net.leidra.gestbe.shared.application.CommandBus;
import net.leidra.gestbe.shared.domain.model.CustomerId;
import net.leidra.gestbe.shared.domain.model.CustomerName;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Transactional
@RestController
@AllArgsConstructor
@RequestMapping("/api/customers/{customer_id}")
public class RestCustomerPutController {
    private CommandBus commandBus;

    @PutMapping
    public ResponseEntity<?> save(@PathVariable("customer_id") final CustomerId customerId,
                                  @RequestBody final CustomerRequest request) {
        commandBus.dispatch(new SaveCustomerCommand(customerId, new CustomerName(request.name())));

        return ResponseEntity.noContent().build();
    }
}
