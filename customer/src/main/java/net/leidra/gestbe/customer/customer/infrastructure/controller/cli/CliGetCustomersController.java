package net.leidra.gestbe.customer.customer.infrastructure.controller.cli;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.customer.application.CustomersSearcher;
import net.leidra.gestbe.customer.customer.infrastructure.controller.CustomerResponse;
import net.leidra.gestbe.customer.customer.infrastructure.controller.CustomersResponse;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public final class CliGetCustomersController {
    private final CustomersSearcher customersSearcher;

    public CustomersResponse searchAll() {
        return CustomersResponse.fromStream(customersSearcher.searchAll()
                .map(CustomerResponse::fromCustomer));
    }
}