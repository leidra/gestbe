package net.leidra.gestbe.customer.customer.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public record Customer(UUID id, String name, LocalDateTime createdOn, LocalDateTime updatedOn) {
}