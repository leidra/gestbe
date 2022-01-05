package net.leidra.gestbe.customer.customer.application;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.customer.domain.model.Customer;
import net.leidra.gestbe.customer.customer.domain.repository.CustomersRepository;
import net.leidra.gestbe.shared.domain.model.CustomerId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@Transactional
@AllArgsConstructor
public class CustomerSearcher {
    private final CustomersRepository repository;

    public Stream<Customer> searchAll() {
        return repository.findAll();
    }

    public Optional<Customer> searchById(final UUID id) {
        return repository.findById(new CustomerId(id));
    }
}
