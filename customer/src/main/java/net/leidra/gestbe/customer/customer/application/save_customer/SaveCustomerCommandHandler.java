package net.leidra.gestbe.customer.customer.application.save_customer;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.shared.application.CommandHandler;
import net.leidra.gestbe.customer.customer.domain.model.CustomerId;
import net.leidra.gestbe.customer.customer.domain.model.CustomerName;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SaveCustomerCommandHandler implements CommandHandler<SaveCustomerCommand> {
    private CustomerSaver saver;

    @Override
    public void handle(final SaveCustomerCommand command) {
        saver.save(new CustomerId(command.customerId()), new CustomerName(command.customerName()));
    }
}
