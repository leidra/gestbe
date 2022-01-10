package net.leidra.gestbe.customer.customer.application.remove_customer;

import net.leidra.gestbe.shared.application.Command;
import net.leidra.gestbe.shared.domain.model.CustomerId;

public record RemoveCustomerCommand(CustomerId id) implements Command {
}
