package net.leidra.gestbe.shared.domain.model;

import lombok.Value;
import org.springframework.util.Assert;

import java.util.UUID;

@Value
public class CustomerId {
    UUID id;

    public CustomerId(final UUID id) {
        guard(id);
        this.id = id;
    }

    public CustomerId(final String id) {
        guard(id);
        this.id = UUID.fromString(id);
    }

    public UUID id() {
        return id;
    }

    public void guard(Object id) {
        Assert.notNull(id, "Customer id cannot be null");
    }
}
