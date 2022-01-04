package net.leidra.gestbe.customer.customer.domain.repository;

import net.leidra.gestbe.customer.customer.domain.model.Customer;
import java.util.stream.Stream;

public interface CustomersRepository {
    Stream<Customer> findAll();
}
