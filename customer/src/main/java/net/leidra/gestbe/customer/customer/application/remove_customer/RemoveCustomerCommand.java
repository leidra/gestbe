package net.leidra.gestbe.customer.customer.application.remove_customer;

import net.leidra.gestbe.shared.application.Command;

import java.util.UUID;

public record RemoveCustomerCommand(UUID id) implements Command {
}
