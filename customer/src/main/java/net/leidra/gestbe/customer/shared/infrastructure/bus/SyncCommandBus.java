package net.leidra.gestbe.customer.shared.infrastructure.bus;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.shared.application.Command;
import net.leidra.gestbe.customer.shared.application.CommandBus;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public final class SyncCommandBus implements CommandBus {
    private final CommandHandlerHolder holder;

    @Override
    public <T extends Command> void dispatch(final T command) {
        holder.resolve((Class<T>) command.getClass()).handle(command);
    }
}
