package net.leidra.gestbe.customer.customer.infrastructure.controller.rest;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.customer.application.CustomerSearcher;
import net.leidra.gestbe.customer.customer.infrastructure.controller.CustomerResponse;
import net.leidra.gestbe.customer.customer.infrastructure.controller.CustomersResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Transactional
@RestController
@AllArgsConstructor
@RequestMapping("/api/customers")
public class RestCustomerGetController {
    private CustomerSearcher searcher;

    @GetMapping
    public CustomersResponse findAll() {
        return CustomersResponse.fromStream(searcher.searchAll()
                .map(CustomerResponse::fromCustomer));
    }
}
