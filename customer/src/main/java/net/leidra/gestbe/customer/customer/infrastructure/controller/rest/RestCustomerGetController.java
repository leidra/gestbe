package net.leidra.gestbe.customer.customer.infrastructure.controller.rest;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.customer.application.search_customer.GetAllCustomersQuery;
import net.leidra.gestbe.customer.customer.domain.model.Customer;
import net.leidra.gestbe.customer.customer.infrastructure.controller.CustomerResponse;
import net.leidra.gestbe.customer.customer.infrastructure.controller.CustomersResponse;
import net.leidra.gestbe.shared.application.QueryBus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@Transactional
@RestController
@AllArgsConstructor
@RequestMapping("/api/customers")
public class RestCustomerGetController {
    private final QueryBus queryBus;

    @GetMapping
    public CustomersResponse findAll() {
        final Stream<Customer> customerStream = queryBus.dispatch(new GetAllCustomersQuery());
        return CustomersResponse.fromStream(customerStream
                .map(CustomerResponse::fromCustomer));
    }
}
