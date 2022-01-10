package net.leidra.gestbe.customer.customer.infrastructure.controller.cli;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.customer.application.search_customer.CustomerSearcher;
import net.leidra.gestbe.customer.customer.infrastructure.controller.CustomerResponse;
import net.leidra.gestbe.customer.customer.infrastructure.controller.CustomersResponse;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@AllArgsConstructor
public class CliGetCustomersController {
    private final CustomerSearcher customerSearcher;

    public CustomersResponse searchAll() {
        return CustomersResponse.fromStream(customerSearcher.searchAll()
                .map(CustomerResponse::fromCustomer));
    }
}