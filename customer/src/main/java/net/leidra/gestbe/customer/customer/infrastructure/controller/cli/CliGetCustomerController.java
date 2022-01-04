package net.leidra.gestbe.customer.customer.infrastructure.controller.cli;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.customer.application.GetCustomers;
import net.leidra.gestbe.customer.customer.infrastructure.controller.CustomerResponse;
import net.leidra.gestbe.customer.customer.infrastructure.controller.CustomersResponse;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public final class CliGetCustomerController {
    private final GetCustomers getCustomers;

    public CustomersResponse findAll() {
        return CustomersResponse.fromStream(getCustomers.findAll()
                .map(CustomerResponse::fromCustomer));
    }
}