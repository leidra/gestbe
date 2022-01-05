package net.leidra.gestbe.customer.customer.infrastructure.controller.rest;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.customer.application.CustomerRemover;
import net.leidra.gestbe.shared.domain.model.CustomerId;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Transactional
@RestController
@AllArgsConstructor
@RequestMapping("/api/customers/{customer_id}")
public class RestCustomerDeleteController {
    private CustomerRemover remover;

    @DeleteMapping
    public ResponseEntity<?> remove(@PathVariable("customer_id") final CustomerId customerId) {
        remover.removeById(customerId.id());

        return ResponseEntity.noContent().build();
    }
}
