package net.leidra.gestbe.customer.customer.application.save_customer;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.customer.domain.model.Customer;
import net.leidra.gestbe.customer.customer.domain.repository.CustomersRepository;
import net.leidra.gestbe.customer.customer.domain.model.AuditDateTime;
import net.leidra.gestbe.customer.customer.domain.model.CustomerId;
import net.leidra.gestbe.customer.customer.domain.model.CustomerName;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@AllArgsConstructor
public class CustomerSaver {
    private final CustomersRepository repository;

    public void save(final CustomerId customerId, final CustomerName customerName) {
        final AuditDateTime nowVO = new AuditDateTime(LocalDateTime.now());

        final Customer customer = repository.findById(customerId)
            .map(existingCustomer -> Customer.update(customerId, customerName, existingCustomer.createdOn(), nowVO))
            .orElse(Customer.create(customerId, customerName, nowVO, nowVO));

        repository.save(customer);
    }
}
