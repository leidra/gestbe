package net.leidra.gestbe.customer.customer.application.remove_customer;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.shared.application.CommandHandler;
import net.leidra.gestbe.shared.domain.model.CustomerId;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public final class RemoveCustomerCommandHandler implements CommandHandler<RemoveCustomerCommand> {
    private final CustomerRemover remover;

    @Override
    public void handle(final RemoveCustomerCommand command) {
        remover.removeById(new CustomerId(command.id()));
    }
}
