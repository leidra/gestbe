package net.leidra.gestbe.customer.customer.infrastructure.model.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.leidra.gestbe.customer.customer.domain.model.Customer;
import net.leidra.gestbe.customer.customer.domain.model.AuditDateTime;
import net.leidra.gestbe.customer.customer.domain.model.CustomerId;
import net.leidra.gestbe.customer.customer.domain.model.CustomerName;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class JdbcCustomer {
    @NotNull
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    @CreatedDate
    private LocalDateTime createdOn = LocalDateTime.now();
    @NotNull
    @LastModifiedDate
    private LocalDateTime updatedOn = LocalDateTime.now();

    public Customer toCustomer() {
        return new Customer(new CustomerId(getId()), new CustomerName(getName()), new AuditDateTime(getCreatedOn()), new AuditDateTime(getUpdatedOn()));
    }

    public static JdbcCustomer fromCustomer(final Customer customer) {
        return new JdbcCustomer(customer.id().id(), customer.name().name(), customer.createdOn().time(), customer.updatedOn().time());
    }
}
