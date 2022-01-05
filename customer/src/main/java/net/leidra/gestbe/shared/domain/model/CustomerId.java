package net.leidra.gestbe.shared.domain.model;

import org.springframework.util.Assert;

import java.util.UUID;

public record CustomerId(UUID id){
    public CustomerId {
        Assert.notNull(id, "Customer id cannot be null");
    }
}
