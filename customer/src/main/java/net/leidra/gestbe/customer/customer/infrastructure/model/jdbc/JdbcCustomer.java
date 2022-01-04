package net.leidra.gestbe.customer.customer.infrastructure.model.jdbc;

import lombok.Data;
import net.leidra.gestbe.customer.customer.domain.model.Customer;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class JdbcCustomer {
    UUID id;
    String name;
    LocalDateTime createdOn = LocalDateTime.now();
    LocalDateTime updatedOn = LocalDateTime.now();

    public Customer toCustomer() {
        return new Customer(getId(), getName(), getCreatedOn(), getUpdatedOn());
    }
}
