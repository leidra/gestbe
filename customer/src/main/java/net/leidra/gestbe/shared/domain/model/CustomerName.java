package net.leidra.gestbe.shared.domain.model;

import org.springframework.util.Assert;

public record CustomerName(String name) {
    public CustomerName {
        Assert.hasText(name, "Customer name is mandatory");
    }
}
