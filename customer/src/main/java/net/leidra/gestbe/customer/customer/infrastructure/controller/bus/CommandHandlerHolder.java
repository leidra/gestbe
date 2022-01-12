package net.leidra.gestbe.customer.customer.infrastructure.controller.bus;

import net.leidra.gestbe.shared.application.Command;
import net.leidra.gestbe.shared.application.CommandHandler;
import org.springframework.stereotype.Component;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public final class CommandHandlerHolder {
    private final Map<Type, CommandHandler<? extends Command>> handlers = new HashMap<>();

    public CommandHandlerHolder(final List<CommandHandler<? extends Command>> handlers) {
        handlers.forEach(h -> this.handlers.put(h.getType(), h));
    }

    public <T extends Command> CommandHandler<T> resolve(final Class<T> type) {
        return (CommandHandler<T>) handlers.get(type);
    }
}
