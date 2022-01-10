package net.leidra.gestbe.customer.customer.application.remove_customer;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.customer.domain.repository.CustomersRepository;
import net.leidra.gestbe.shared.domain.model.CustomerId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CustomerRemover {
    private final CustomersRepository repository;

    public void removeById(final CustomerId customerId) {
        repository.deleteById(customerId);
    }
}
