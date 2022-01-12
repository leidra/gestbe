package net.leidra.gestbe.customer.customer.infrastructure.controller.cli;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.customer.application.search_customer.GetAllCustomersQuery;
import net.leidra.gestbe.customer.customer.domain.model.Customer;
import net.leidra.gestbe.customer.customer.infrastructure.controller.CustomerResponse;
import net.leidra.gestbe.customer.customer.infrastructure.controller.CustomersResponse;
import net.leidra.gestbe.shared.application.QueryBus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Component
@Transactional
@AllArgsConstructor
public class CustomerGetCliController {
    private final QueryBus queryBus;

    public CustomersResponse searchAll() {
        final Stream<Customer> customerStream = queryBus.dispatch(new GetAllCustomersQuery());
        return CustomersResponse.fromStream(customerStream
                .map(CustomerResponse::fromCustomer));
    }
}