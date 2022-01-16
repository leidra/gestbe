package net.leidra.gestbe.customer.customer.domain.model;

public record Customer(CustomerId id, CustomerName name, AuditDateTime createdOn, AuditDateTime updatedOn) {
    public static Customer create(final CustomerId id, final CustomerName name, final AuditDateTime createdOn, final AuditDateTime updatedOn) {
        return new Customer(id, name, createdOn, updatedOn);
    }

    public static Customer update(final CustomerId id, final CustomerName name, final AuditDateTime createdOn, final AuditDateTime updatedOn) {
        return new Customer(id, name, createdOn, updatedOn);
    }
}