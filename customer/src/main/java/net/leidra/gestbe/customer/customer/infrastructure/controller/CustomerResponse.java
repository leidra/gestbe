package net.leidra.gestbe.customer.customer.infrastructure.controller;

import net.leidra.gestbe.customer.customer.domain.model.Customer;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public record CustomerResponse(UUID id, String name, LocalDateTime createdOn, LocalDateTime updatedOn) implements Serializable {
    public static CustomerResponse fromCustomer(final Customer customer) {
        return new CustomerResponse(customer.id().id(), customer.name().name(), customer.createdOn().time(), customer.updatedOn().time());
    }
}
