package net.leidra.gestbe.customer.customer.domain.model;

import net.leidra.gestbe.shared.domain.model.AuditDateTime;
import net.leidra.gestbe.shared.domain.model.CustomerId;
import net.leidra.gestbe.shared.domain.model.CustomerName;

public record Customer(CustomerId id, CustomerName name, AuditDateTime createdOn, AuditDateTime updatedOn) {
    public static Customer create(final CustomerId id, final CustomerName name, final AuditDateTime createdOn, final AuditDateTime updatedOn) {
        return new Customer(id, name, createdOn, updatedOn);
    }

    public static Customer update(final CustomerId id, final CustomerName name, final AuditDateTime createdOn, final AuditDateTime updatedOn) {
        return new Customer(id, name, createdOn, updatedOn);
    }
}