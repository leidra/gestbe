package net.leidra.gestbe.shared.domain.model;

import org.springframework.util.Assert;

import java.time.LocalDateTime;

public record AuditDateTime(LocalDateTime time) {
    public AuditDateTime {
        Assert.notNull(time, "Date time cannot be null");
    }
}
