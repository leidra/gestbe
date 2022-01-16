package net.leidra.gestbe.customer.customer.application.save_customer;

import net.leidra.gestbe.customer.shared.application.Command;

import java.util.UUID;

public record SaveCustomerCommand(UUID customerId, String customerName) implements Command {
}
