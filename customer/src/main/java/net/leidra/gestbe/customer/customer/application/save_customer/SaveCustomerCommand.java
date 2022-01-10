package net.leidra.gestbe.customer.customer.application.save_customer;

import net.leidra.gestbe.shared.application.Command;
import net.leidra.gestbe.shared.domain.model.CustomerId;
import net.leidra.gestbe.shared.domain.model.CustomerName;

public record SaveCustomerCommand(CustomerId customerId, CustomerName customerName) implements Command {
}
