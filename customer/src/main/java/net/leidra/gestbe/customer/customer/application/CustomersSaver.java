package net.leidra.gestbe.customer.customer.application;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.customer.domain.model.Customer;
import net.leidra.gestbe.customer.customer.domain.repository.CustomersRepository;
import net.leidra.gestbe.shared.domain.model.AuditDateTime;
import net.leidra.gestbe.shared.domain.model.CustomerId;
import net.leidra.gestbe.shared.domain.model.CustomerName;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public final class CustomersSaver {
    private final CustomersRepository repository;

    public void save(UUID id, String name, LocalDateTime createdOn, LocalDateTime updatedOn) {
        final CustomerId customerId = new CustomerId(id);

        final Customer customer;
        if(repository.existsById(customerId)) {
            customer = Customer.update(customerId, new CustomerName(name), new AuditDateTime(createdOn), new AuditDateTime(updatedOn));
        } else {
            customer = Customer.create(customerId, new CustomerName(name), new AuditDateTime(createdOn), new AuditDateTime(updatedOn));
        }

        repository.save(customer);
    }
}
