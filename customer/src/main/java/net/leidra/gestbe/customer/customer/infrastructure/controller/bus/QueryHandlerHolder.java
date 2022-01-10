package net.leidra.gestbe.customer.customer.infrastructure.controller.bus;

import net.leidra.gestbe.shared.application.Query;
import net.leidra.gestbe.shared.application.QueryHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public final class QueryHandlerHolder {
    private final Map<Type, QueryHandler<? extends Query<?>, ?>> handlers = new HashMap<>();

    public QueryHandlerHolder(final List<? extends QueryHandler<? extends Query<?>, ?>> handlers) {
        handlers.forEach(h -> this.handlers.put(h.getType(), h));
    }

    public <R, T extends Query<R>> QueryHandler<T, R> resolve(Class<T> type) {
        return (QueryHandler<T, R>) handlers.get(type);
    }

}
