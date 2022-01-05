package net.leidra.gestbe.customer.customer.application;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.customer.domain.repository.CustomersRepository;
import net.leidra.gestbe.shared.domain.model.CustomerId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class CustomerRemover {
    private final CustomersRepository repository;

    public void removeById(UUID id) {
        final CustomerId customerId = new CustomerId(id);

        repository.deleteById(customerId);
    }
}
