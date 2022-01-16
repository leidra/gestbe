package net.leidra.gestbe.customer.customer.domain.repository;

import net.leidra.gestbe.customer.customer.domain.model.Customer;
import net.leidra.gestbe.customer.customer.domain.model.CustomerId;

import java.util.Optional;
import java.util.stream.Stream;

public interface CustomersRepository {
    Stream<Customer> findAll();

    void save(final Customer customer);

    Optional<Customer> findById(CustomerId customerId);

    Boolean existsById(CustomerId customerId);

    void deleteById(CustomerId customerId);
}
