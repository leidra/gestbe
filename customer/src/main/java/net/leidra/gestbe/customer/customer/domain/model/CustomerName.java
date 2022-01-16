package net.leidra.gestbe.customer.customer.domain.model;

import org.springframework.util.Assert;

public record CustomerName(String name) {
    public CustomerName {
        Assert.hasText(name, "Customer name is mandatory");
    }
}
