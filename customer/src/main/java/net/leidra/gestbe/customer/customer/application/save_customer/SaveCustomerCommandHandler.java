package net.leidra.gestbe.customer.customer.application.save_customer;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.shared.application.CommandHandler;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SaveCustomerCommandHandler implements CommandHandler<SaveCustomerCommand> {
    private CustomerSaver saver;

    @Override
    public void handle(final SaveCustomerCommand command) {
        saver.save(command.customerId(), command.customerName());
    }
}
