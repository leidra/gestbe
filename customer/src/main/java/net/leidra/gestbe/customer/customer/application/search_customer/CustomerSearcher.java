package net.leidra.gestbe.customer.customer.application.search_customer;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.customer.domain.model.Customer;
import net.leidra.gestbe.customer.customer.domain.repository.CustomersRepository;
import net.leidra.gestbe.customer.customer.domain.model.CustomerId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@Transactional
@AllArgsConstructor
public class CustomerSearcher {
    private final CustomersRepository repository;

    public Stream<Customer> searchAll() {
        return repository.findAll();
    }

    public Optional<Customer> searchById(final CustomerId id) {
        return repository.findById(id);
    }
}
