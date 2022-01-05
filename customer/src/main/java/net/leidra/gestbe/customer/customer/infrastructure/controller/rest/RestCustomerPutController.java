package net.leidra.gestbe.customer.customer.infrastructure.controller.rest;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.customer.application.CustomerSaver;
import net.leidra.gestbe.shared.domain.model.CustomerId;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Transactional
@RestController
@AllArgsConstructor
@RequestMapping("/api/customers/{customer_id}")
public class RestCustomerPutController {
    private CustomerSaver saver;

    @PutMapping
    public ResponseEntity<?> save(@PathVariable("customer_id") final CustomerId customerId,
                               @RequestBody final CustomerRequest request) {
        saver.save(customerId.id(), request.name());

        return ResponseEntity.noContent().build();
    }
}
